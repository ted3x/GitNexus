/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import arrow.core.Either
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import kotlinx.coroutines.launch
import me.manvelidze.nexus.domain.auth.client.AuthClient
import me.manvelidze.nexus.ui.dashboard.DashboardScreens
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject

@Inject
class AuthPresenter(
    @Assisted private val navigator: Navigator,
    private val client: AuthClient,
) : Presenter<AuthUiState> {
    @Composable
    override fun present(): AuthUiState {
        val scope = rememberCoroutineScope()
        client.onOAuthListener { result ->
            scope.launch {
                println(result)
                when (result) {
                    is Either.Left -> throw result.value
                    is Either.Right ->
                        client
                            .accessToken(result.value)
                            .also { eventSink(AuthUiEvent.Authorized) }
                }
            }
        }
        return AuthUiState(eventSink = ::eventSink)
    }

    private fun eventSink(event: AuthUiEvent) {
        when (event) {
            AuthUiEvent.Authorized -> {
                client.killServer()
                navigator.goTo(DashboardScreens.Dashboard)
            }
            AuthUiEvent.SignWithGithub -> client.signWithGithub()
        }
    }

    @Inject
    class Factory(
        private val modelFactory: (navigator: Navigator) -> AuthPresenter,
    ) : Presenter.Factory {
        override fun create(
            screen: Screen,
            navigator: Navigator,
            context: CircuitContext,
        ): Presenter<*>? =
            when (screen) {
                is AuthScreens.Auth -> modelFactory.invoke(navigator)
                else -> null
            }
    }
}
