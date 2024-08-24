/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.data.auth.client

import arrow.core.Either
import com.sun.net.httpserver.HttpServer
import io.ktor.client.call.body
import io.ktor.client.request.post
import me.manvelidze.nexus.core.base.browser.Browser
import me.manvelidze.nexus.core.network.KtorClient
import me.manvelidze.nexus.core.network.error.NotFound
import me.manvelidze.nexus.data.auth.BuildKonfig
import me.manvelidze.nexus.data.auth.dto.AccessTokenResponseDto
import me.manvelidze.nexus.domain.auth.client.AuthClient
import me.manvelidze.nexus.domain.auth.model.AccessTokenResponse
import me.manvelidze.nexus.domain.auth.model.OAuthCode
import me.tatarka.inject.annotations.Inject
import java.net.InetSocketAddress

@Inject
class AuthClientImpl(
    private val client: KtorClient,
    private val browser: Browser,
) : AuthClient {
    private var server: HttpServer? = null

    override suspend fun accessToken(code: String): AccessTokenResponse =
        client.client
            .post("https://github.com/login/oauth/access_token") {
                url {
                    parameters.append("client_id", BuildKonfig.OAuthClientID)
                    parameters.append("client_secret", BuildKonfig.OAuthClientSecret)
                    parameters.append("code", code)
                }
            }.body<AccessTokenResponseDto>()
            .mapToDomain()

    override fun signWithGithub() {
        val url =
            "https://github.com/login/oauth/authorize?" +
                "client_id=${BuildKonfig.OAuthClientID}&" +
                "scope=admin%3Apublic_key%2Crepo%2Cworkflow%2Cread%3Aorg%2Cuser%3Aemail&" +
                "response_type=code"
        browser.browse(url)
    }

    override fun onOAuthListener(callback: (response: Either<Exception, OAuthCode>) -> Unit) {
        HttpServer.create(InetSocketAddress(8822), 0).apply {
            server = this
            createContext("/") { exchange ->
                val query = exchange.requestURI.query
                val params =
                    query.split("&").associate {
                        val (key, value) = it.split("=")
                        key to value
                    }
                val code = params["code"]
                if (code != null) {
                    callback.invoke(Either.Right(code))
                } else {
                    callback.invoke(Either.Left(NotFound))
                }
            }
            executor = null
            start()
        }
    }

    override fun killServer() {
        server?.stop(0)
        server = null
    }
}
