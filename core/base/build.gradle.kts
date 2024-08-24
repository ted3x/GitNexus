/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */

plugins {
    alias(libs.plugins.nexus.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.arrow.core)
            implementation(libs.kotlin.inject.runtime)
        }
    }
}