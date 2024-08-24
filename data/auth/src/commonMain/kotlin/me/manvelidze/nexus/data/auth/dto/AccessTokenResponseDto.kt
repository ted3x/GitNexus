/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.data.auth.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.manvelidze.nexus.domain.auth.model.AccessTokenResponse

@Serializable
data class AccessTokenResponseDto(
    @SerialName("access_token")
    val accessToken: String,
    val scope: String?,
    @SerialName("token_type")
    val tokenType: String?,
) {
    fun mapToDomain() = AccessTokenResponse(accessToken)
}
