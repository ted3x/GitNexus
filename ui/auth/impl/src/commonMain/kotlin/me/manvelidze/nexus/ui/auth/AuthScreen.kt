/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gabrieldrn.carbon.Carbon
import com.gabrieldrn.carbon.button.Button
import com.gabrieldrn.carbon.foundation.color.containerBackground
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import me.manvelidze.nexus.resources.SharedDrawable
import me.manvelidze.nexus.resources.github_mark
import me.tatarka.inject.annotations.Inject
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Inject
class AuthScreenFactory : Ui.Factory {
    override fun create(
        screen: Screen,
        context: CircuitContext,
    ): Ui<*>? =
        when (screen) {
            is AuthScreens.Auth -> {
                ui<AuthUiState> { state, modifier ->
                    AuthScreen(state, modifier)
                }
            }

            else -> null
        }
}

@Composable
fun AuthScreen(
    state: AuthUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize().containerBackground(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BasicText(
            text = stringResource(Res.string.auth_welcome),
            style = Carbon.typography.heading04.copy(color = Carbon.theme.textPrimary),
        )

        Spacer(modifier = Modifier.height(40.dp))
        Button(
            label = stringResource(Res.string.auth_sign_with_github),
            iconPainter = painterResource(SharedDrawable.github_mark),
            onClick = {
                state.eventSink.invoke(AuthUiEvent.SignWithGithub)
            })
    }
}
