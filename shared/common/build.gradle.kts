/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
import me.manvelidze.nexus.gradle.addKspDependencyForAllTargets

plugins {
    alias(libs.plugins.nexus.multiplatform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.apollo)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(projects.core.base)
                api(projects.core.di)
                api(projects.core.network)

                api(projects.resources)

                api(projects.data.auth)
                api(projects.domain.auth)
                api(projects.feature.auth)

                api(libs.apollo)
            }
        }
    }
}

ksp {
    arg("me.tatarka.inject.generateCompanionExtensions", "true")
}

apollo {
    service("service") {
        packageName.set("me.manvelidze.nexus")
    }
}

addKspDependencyForAllTargets(libs.kotlin.inject.compiler)
