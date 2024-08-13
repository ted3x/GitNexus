/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.spotless) apply false
}

allprojects {
    apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        val ktlintVersion = "1.3.1"
        kotlin {
            target("src/**/*.kt")
            ktlint(ktlintVersion)
            licenseHeaderFile(rootProject.file("spotless/copyright.txt"))
        }

        kotlinGradle {
            target("*.kts")
            ktlint(ktlintVersion)
            licenseHeaderFile(rootProject.file("spotless/copyright.txt"), "(^(?![\\/ ]\\**).*$)")
        }
    }
}
