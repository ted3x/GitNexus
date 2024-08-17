/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
plugins {
    `kotlin-dsl`
    alias(libs.plugins.spotless)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

spotless {
    kotlin {
        target("src/**/*.kt")
        ktlint()
        licenseHeaderFile(rootProject.file("../../spotless/copyright.txt"))
    }

    kotlinGradle {
        target("*.kts")
        ktlint()
        licenseHeaderFile(rootProject.file("../../spotless/copyright.txt"), "(^(?![\\/ ]\\**).*$)")
    }
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.composeCompiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform") {
            id = "me.manvelidze.multiplatform"
            implementationClass = "me.manvelidze.nexus.gradle.KotlinMultiplatformConventionPlugin"
        }

        register("root") {
            id = "me.manvelidze.root"
            implementationClass = "me.manvelidze.nexus.gradle.RootConventionPlugin"
        }

        register("compose") {
            id = "me.manvelidze.compose"
            implementationClass = "me.manvelidze.nexus.gradle.ComposeMultiplatformConventionPlugin"
        }
    }
}
