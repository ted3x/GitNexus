/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.dashboard.component

import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.IntoSet
import me.tatarka.inject.annotations.Provides

@Component
interface DashboardUiComponent {
    @Provides
    @IntoSet
    fun providesDashboardPresenterFactory(factory: DashboardPresenter.Factory): Presenter.Factory = factory

    @Provides
    @IntoSet
    fun providesDashboardUiFactory(factory: DashboardUiFactory): Ui.Factory = factory
}
