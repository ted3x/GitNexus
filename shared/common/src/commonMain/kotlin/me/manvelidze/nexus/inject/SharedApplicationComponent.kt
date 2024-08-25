/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.inject

import me.manvelidze.nexus.data.auth.component.AuthPlatformComponent
import me.manvelidze.nexus.ui.auth.component.AuthUiComponent
import me.manvelidze.nexus.ui.dashboard.component.DashboardUiComponent

expect interface SharedPlatformApplicationComponent

interface SharedApplicationComponent :
    SharedPlatformApplicationComponent,
    AuthUiComponent,
    AuthPlatformComponent,
    DashboardUiComponent
