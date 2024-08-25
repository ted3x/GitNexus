/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.dashboard.component

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState

data class DashboardUiState(
    val eventSink: (DashboardEvent) -> Unit,
) : CircuitUiState

sealed interface DashboardEvent : CircuitUiEvent
