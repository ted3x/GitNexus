/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.ui.screen

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

val LocalScreenModelComponent: ProvidableCompositionLocal<ScreenModelComponent?> =
    staticCompositionLocalOf { null }
