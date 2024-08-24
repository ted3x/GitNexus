/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.feature.auth.component

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import me.manvelidze.nexus.feature.auth.AuthModel
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
interface AuthUiComponent {
    val model: AuthModel

    // TODO: Refactor
    @Provides
    fun providesCoroutineScope() = CoroutineScope(Dispatchers.IO)
}
