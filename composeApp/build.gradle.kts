/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
}

kotlin {
    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            api(libs.carbon)

            implementation(libs.kotlin.inject.runtime)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

compose.desktop {
    application {
        mainClass = "me.manvelidze.nexus.MainKt"

        nativeDistributions {
            macOS {
                iconFile.set(project.file("src/logos/logo.icns"))
            }
            windows {
                iconFile.set(project.file("src/logos/icon.ico"))
            }
            linux {
                iconFile.set(project.file("src/logos/icon.png"))
            }
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "GitNexus"
            packageVersion = "1.0.0"
        }
    }
}

dependencies {
    // KSP will eventually have better multiplatform support and we'll be able to simply have
    // `ksp libs.kotlinInject.compiler` in the dependencies block of each source set
    // https://github.com/google/ksp/pull/1021
    add("kspDesktop", libs.kotlin.inject.compiler)
}
