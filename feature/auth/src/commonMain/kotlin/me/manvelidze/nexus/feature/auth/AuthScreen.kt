/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.feature.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gabrieldrn.carbon.Carbon
import com.gabrieldrn.carbon.button.IconButton
import com.gabrieldrn.carbon.foundation.color.containerBackground
import me.manvelidze.nexus.resources.SharedDrawable
import me.manvelidze.nexus.resources.github_mark
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun AuthScreen(
    model: AuthModel,
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

        IconButton(painterResource(SharedDrawable.github_mark), onClick = {
            model.signInWithGithub()
        })
    }
}
