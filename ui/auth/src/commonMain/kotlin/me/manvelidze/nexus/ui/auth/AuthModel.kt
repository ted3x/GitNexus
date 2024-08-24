/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.auth

import arrow.core.Either
import cafe.adriel.voyager.core.model.screenModelScope
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.launch
import me.manvelidze.nexus.core.ui.screen.BaseScreenModel
import me.manvelidze.nexus.core.ui.screen.ScreenModelFactory
import me.manvelidze.nexus.domain.auth.client.AuthClient
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject

@Inject
class AuthModel(
    @Assisted private val navigator: Navigator,
    private val client: AuthClient,
) : BaseScreenModel(navigator) {
    init {
        client.onOAuthListener { result ->
            screenModelScope.launch {
                println(result)
                when (result) {
                    is Either.Left -> throw result.value
                    is Either.Right ->
                        client
                            .accessToken(result.value)
                            .also { onAccessTokenReceived(it.token) }
                }
            }
        }
    }

    fun signInWithGithub() {
        client.signWithGithub()
    }

    private fun onAccessTokenReceived(token: String) {
        // Insert token in DB
    }

    override fun onDispose() {
        super.onDispose()
        client.killServer()
    }

    @Inject
    class Factory(
        private val modelFactory: (navigator: Navigator) -> AuthModel,
    ) : ScreenModelFactory {
        override fun create(
            screen: Screen,
            navigator: Navigator,
        ): BaseScreenModel? =
            when (screen) {
                is AuthScreen -> modelFactory(navigator)
                else -> null
            }
    }
}
