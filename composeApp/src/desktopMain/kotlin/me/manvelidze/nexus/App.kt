/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gabrieldrn.carbon.CarbonDesignSystem
import com.gabrieldrn.carbon.button.Button
import com.gabrieldrn.carbon.foundation.color.Gray100Theme
import com.gabrieldrn.carbon.foundation.color.containerBackground
import gitnexus.composeapp.generated.resources.Res
import gitnexus.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    CarbonDesignSystem(uiShellInlineTheme = Gray100Theme) {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth().containerBackground(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button("Click me!", onClick = { showContent = !showContent })
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
