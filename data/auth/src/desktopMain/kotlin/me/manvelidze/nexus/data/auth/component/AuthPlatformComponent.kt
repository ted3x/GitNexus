/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.data.auth.component

import me.manvelidze.nexus.core.base.browser.Browser
import me.manvelidze.nexus.core.base.browser.BrowserImpl
import me.manvelidze.nexus.data.auth.client.AuthClientImpl
import me.manvelidze.nexus.domain.auth.client.AuthClient
import me.manvelidze.nexus.domain.auth.component.AuthComponent
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
interface AuthPlatformComponent : AuthComponent {
    @Provides
    fun bindsOAuthClient(impl: AuthClientImpl): AuthClient = impl

    @Provides
    fun bindsBrowser(impl: BrowserImpl): Browser = impl

    companion object
}
