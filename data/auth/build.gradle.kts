/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
import com.codingfeline.buildkonfig.compiler.FieldSpec
import java.util.Properties

plugins {
    alias(libs.plugins.nexus.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.buildkonfig)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.base)
            implementation(projects.core.network)
            implementation(projects.domain.auth)

            implementation(libs.kotlin.inject.runtime)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.serialization.json)
        }
    }
}

buildkonfig {
    packageName = "me.manvelidze.nexus.data.auth"

    defaultConfigs {
        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        buildConfigField(
            FieldSpec.Type.STRING,
            "OAuthClientID",
            "Ov23ctZmz88Wg1mXCJjr",
        )
        buildConfigField(
            FieldSpec.Type.STRING,
            "OAuthClientSecret",
            properties.getProperty("oauth_client_secret"),
        )
    }
}
