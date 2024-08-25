/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
import me.manvelidze.nexus.gradle.addKspDependencyForAllTargets
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.nexus.compose)
    alias(libs.plugins.nexus.multiplatform)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(projects.shared.common)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
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

ksp {
    arg("me.tatarka.inject.generateCompanionExtensions", "true")
}

addKspDependencyForAllTargets(libs.kotlin.inject.compiler)
