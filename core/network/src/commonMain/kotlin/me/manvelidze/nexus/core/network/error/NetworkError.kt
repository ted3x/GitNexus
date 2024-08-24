/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.network.error

sealed class NetworkError : Exception()

data object NotFound : NetworkError() {
    private fun readResolve(): Any = NotFound
}
