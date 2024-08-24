/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import me.tatarka.inject.annotations.Inject

@Inject
actual class KtorClient {
    @OptIn(ExperimentalSerializationApi::class)
    actual val client =
        HttpClient(Java) {
            install(ContentNegotiation) {
                json(
                    json =
                        Json {
                            encodeDefaults = true
                            explicitNulls = false
                            ignoreUnknownKeys = true
                        },
                )
            }
            engine {
                protocolVersion = java.net.http.HttpClient.Version.HTTP_2
            }
        }
}
