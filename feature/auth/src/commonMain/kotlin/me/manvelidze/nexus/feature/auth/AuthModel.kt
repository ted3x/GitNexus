/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.feature.auth

import arrow.core.Either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.manvelidze.nexus.domain.auth.client.AuthClient
import me.tatarka.inject.annotations.Inject

@Inject
class AuthModel(
    private val client: AuthClient,
    private val scope: CoroutineScope,
) {
    init {
        client.onOAuthListener { result ->
            scope.launch {
                println(result)
                when (result) {
                    is Either.Left -> throw result.value
                    is Either.Right ->
                        client
                            .accessToken(result.value)
                            .also { onAccessTokenReceived(it.token) }
                }
            }
        }
    }

    fun signInWithGithub() {
        client.signWithGithub()
    }

    private fun onAccessTokenReceived(token: String) {
        // Insert token in DB
    }
}
