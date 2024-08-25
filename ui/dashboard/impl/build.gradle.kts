/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */

plugins {
    alias(libs.plugins.nexus.multiplatform)
    alias(libs.plugins.nexus.compose)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvm("desktop")
    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(projects.core.ui)
            implementation(projects.core.di)
            implementation(projects.resources)
            implementation(projects.core.base)
            implementation(projects.core.network)

            implementation(projects.domain.dashboard)
            implementation(projects.ui.dashboard.api)

            implementation(compose.foundation)
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.carbon)
            implementation(libs.kotlin.inject.runtime)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "me.manvelidze.nexus.ui.dashboard"
    generateResClass = always
}
