/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import me.manvelidze.nexus.core.ui.screen.ScreenFactoryResolver.rememberScreenModel

@Composable
inline fun <reified T : ScreenModel> Screen.rememberScreenModel(tag: String? = null) =
    rememberScreenModel<T>(this, tag)
