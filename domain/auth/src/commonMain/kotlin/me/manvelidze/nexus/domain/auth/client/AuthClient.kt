/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.domain.auth.client

import arrow.core.Either
import me.manvelidze.nexus.domain.auth.model.AccessTokenResponse
import me.manvelidze.nexus.domain.auth.model.OAuthCode

interface AuthClient {
    suspend fun accessToken(code: String): AccessTokenResponse

    fun signWithGithub()

    fun onOAuthListener(callback: (response: Either<Exception, OAuthCode>) -> Unit)

    fun killServer()
}
