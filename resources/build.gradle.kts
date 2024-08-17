/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */

plugins {
    alias(libs.plugins.nexus.multiplatform)
    alias(libs.plugins.nexus.compose)
}

compose.resources {
    publicResClass = true
    packageOfResClass = "me.manvelidze.nexus.resources"
    generateResClass = always
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.carbon)
            implementation(compose.foundation)
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        }
    }
}
