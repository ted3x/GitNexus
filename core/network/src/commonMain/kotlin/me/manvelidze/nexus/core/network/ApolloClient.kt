/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.network

class ApolloClient {
    private lateinit var client: com.apollographql.apollo.ApolloClient

    fun initialize(token: String) {
        client =
            com.apollographql.apollo.ApolloClient
                .Builder()
                .serverUrl("https://api.github.com/graphql")
                .addHttpHeader("Authorization", "Bearer $token")
                .build()
    }
}
