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
    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(projects.core.di)
            implementation(projects.core.base)
            implementation(projects.core.network)
            implementation(projects.resources)

            implementation(projects.domain.auth)
            implementation(projects.ui.auth.api)

            implementation(projects.ui.dashboard.api)

            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.carbon)
            implementation(libs.circuit.foundation)
            implementation(libs.kotlin.inject.runtime)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "me.manvelidze.nexus.ui.auth"
    generateResClass = always
}
