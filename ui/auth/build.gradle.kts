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
            implementation(projects.core.base)
            implementation(projects.resources)
            implementation(projects.core.network)
            implementation(projects.domain.auth)

            implementation(libs.carbon)
            implementation(compose.foundation)
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

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
