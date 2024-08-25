/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.gabrieldrn.carbon.CarbonDesignSystem
import com.gabrieldrn.carbon.foundation.color.Gray100Theme
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import me.manvelidze.nexus.inject.DesktopApplicationComponent
import me.manvelidze.nexus.inject.create
import me.manvelidze.nexus.ui.auth.AuthScreens

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
                val backStack = rememberSaveableBackStack(listOf(AuthScreens.Auth))
                val navigator = rememberCircuitNavigator(backStack) { }
                CircuitCompositionLocals(component.circuit) {
                    NavigableCircuitContent(
                        navigator = navigator,
                        backStack = backStack,
                        modifier = Modifier,
                    )
                }
            }
        }
    }
