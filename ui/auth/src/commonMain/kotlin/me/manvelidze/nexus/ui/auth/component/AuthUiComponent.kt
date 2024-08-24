/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.auth.component

import me.manvelidze.nexus.core.ui.screen.ScreenModelFactory
import me.manvelidze.nexus.ui.auth.AuthModel
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.IntoSet
import me.tatarka.inject.annotations.Provides

@Component
interface AuthUiComponent {
    @Provides
    @IntoSet
    fun bindsAuthModelFactory(factory: AuthModel.Factory): ScreenModelFactory = factory

    companion object
}
