/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.auth

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState

data class AuthUiState(
    val eventSink: (AuthUiEvent) -> Unit,
) : CircuitUiState

sealed interface AuthUiEvent : CircuitUiEvent {
    data object SignWithGithub : AuthUiEvent

    data object Authorized : AuthUiEvent
}
