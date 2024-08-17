/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.network

import me.manvelidze.nexus.core.network.error.NetworkError

sealed class NetworkResult<out S> {
    data class Success<S>(
        val data: S,
    ) : NetworkResult<S>()

    data class Fail(
        val error: NetworkError,
    ) : NetworkResult<Nothing>()

    companion object {
        fun <S> success(data: S) = Success(data)

        fun <E : NetworkError> fail(error: NetworkError) = Fail(error)
    }
}
