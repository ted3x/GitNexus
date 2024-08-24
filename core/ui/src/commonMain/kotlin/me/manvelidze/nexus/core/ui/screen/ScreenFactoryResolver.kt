/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.core.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.InternalCoroutinesApi

@PublishedApi
internal object ScreenFactoryResolver {
    var factories: Set<ScreenModelFactory>? = null
        private set
    private val factoryLock = Any()

    @Composable
    inline fun <reified T : ScreenModel> rememberScreenModel(
        screen: Screen,
        tag: String? = null,
    ): T {
        initializeFactoriesIfNeeded()

        val navigator = LocalNavigator.currentOrThrow
        return screen.rememberScreenModel(tag) {
            factories?.forEach { factory ->
                factory.create(screen, navigator)?.let { model ->
                    return@rememberScreenModel model as T
                }
            }
            throw RuntimeException("Factory was not found for ${screen.javaClass.simpleName}")
        }
    }

    @OptIn(InternalCoroutinesApi::class)
    @Composable
    @PublishedApi
    internal fun initializeFactoriesIfNeeded() {
        kotlinx.coroutines.internal.synchronized(factoryLock) {
            if (factories == null) {
                factories = LocalScreenModelComponent.currentOrThrow.modelFactories
            }
        }
    }
}
