/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.ui.screen

import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator

interface ScreenModelFactory {
    fun create(
        screen: Screen,
        navigator: Navigator,
    ): BaseScreenModel?
}
