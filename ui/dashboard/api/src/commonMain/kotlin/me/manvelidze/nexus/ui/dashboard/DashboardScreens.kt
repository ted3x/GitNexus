/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.dashboard

import com.slack.circuit.runtime.screen.Screen

sealed class DashboardScreens : Screen {
    data object Dashboard : DashboardScreens()
}
