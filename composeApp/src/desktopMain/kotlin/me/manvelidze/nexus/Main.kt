/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.gabrieldrn.carbon.CarbonDesignSystem
import com.gabrieldrn.carbon.foundation.color.Gray100Theme
import me.manvelidze.nexus.feature.auth.AuthScreen

fun main() =
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "",
        ) {
            CarbonDesignSystem(Gray100Theme, uiShellInlineTheme = Gray100Theme) {
                AuthScreen()
            }
        }
    }
