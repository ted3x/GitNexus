/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.inject

import me.tatarka.inject.annotations.Component

@Component
abstract class DesktopApplicationComponent : SharedApplicationComponent {
    companion object
}
