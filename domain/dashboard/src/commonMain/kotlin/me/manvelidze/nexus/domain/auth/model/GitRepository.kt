/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.domain.auth.model

data class GitRepository(
    val name: String,
    val owner: String,
    val isFavorite: Boolean,
    val branch: String,
)
