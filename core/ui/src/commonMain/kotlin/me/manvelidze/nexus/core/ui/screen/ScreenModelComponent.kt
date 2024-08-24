/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.ui.screen

import me.tatarka.inject.annotations.Component

@Component
interface ScreenModelComponent {
    val modelFactories: Set<ScreenModelFactory>
}
