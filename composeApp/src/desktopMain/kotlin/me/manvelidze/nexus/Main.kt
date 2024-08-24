/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator
import com.gabrieldrn.carbon.CarbonDesignSystem
import com.gabrieldrn.carbon.foundation.color.Gray100Theme
import me.manvelidze.nexus.core.ui.screen.LocalScreenModelComponent
import me.manvelidze.nexus.inject.DesktopApplicationComponent
import me.manvelidze.nexus.inject.create
import me.manvelidze.nexus.ui.auth.AuthScreen

fun main() =
    application {
        val component =
            remember {
                DesktopApplicationComponent.create()
            }
        Window(
            onCloseRequest = ::exitApplication,
            title = "",
        ) {
            CarbonDesignSystem(Gray100Theme, uiShellInlineTheme = Gray100Theme) {
                CompositionLocalProvider(LocalScreenModelComponent provides component) {
                    Navigator(AuthScreen())
                }
            }
        }
    }
