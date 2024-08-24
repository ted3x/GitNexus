/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.base.browser

import me.tatarka.inject.annotations.Inject
import java.awt.Desktop
import java.net.URI
import java.util.Locale

@Inject
class BrowserImpl : Browser {
    override fun browse(url: String) {
        openInBrowser(URI(url))
    }

    private fun openInBrowser(uri: URI) {
        val osName by lazy(LazyThreadSafetyMode.NONE) {
            System.getProperty("os.name").lowercase(
                Locale.getDefault(),
            )
        }
        val desktop = Desktop.getDesktop()
        when {
            Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE) -> desktop.browse(uri)
            "mac" in osName -> Runtime.getRuntime().exec("open $uri")
            "nix" in osName || "nux" in osName -> Runtime.getRuntime().exec("xdg-open $uri")
            else -> throw RuntimeException("cannot open $uri")
        }
    }
}
