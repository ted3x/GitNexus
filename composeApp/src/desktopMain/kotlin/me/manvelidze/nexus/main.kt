package me.manvelidze.nexus

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "GitNexus",
    ) {
        App()
    }
}