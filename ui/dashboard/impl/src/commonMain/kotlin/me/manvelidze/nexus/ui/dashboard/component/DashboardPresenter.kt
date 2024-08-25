/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.dashboard.component

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import me.manvelidze.nexus.ui.dashboard.DashboardScreens
import me.tatarka.inject.annotations.Inject

@Inject
class DashboardPresenter : Presenter<DashboardUiState> {
    @Composable
    override fun present(): DashboardUiState = DashboardUiState { }

    @Inject
    class Factory(
        private val modelFactory: (navigator: Navigator) -> DashboardPresenter,
    ) : Presenter.Factory {
        override fun create(
            screen: Screen,
            navigator: Navigator,
            context: CircuitContext,
        ): Presenter<*>? =
            when (screen) {
                is DashboardScreens.Dashboard -> modelFactory.invoke(navigator)
                else -> null
            }
    }
}
