/*
 * Copyright 2024, Tedo Manvelidze and the GitNexus project contributors
 * SPDX-License-Identifier: AGPL-3.0
 *
 * Author: Tedo Manvelidze
 */
package me.manvelidze.nexus.ui.auth.component

import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import me.manvelidze.nexus.ui.auth.AuthPresenter
import me.manvelidze.nexus.ui.auth.AuthScreenFactory
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.IntoSet
import me.tatarka.inject.annotations.Provides

@Component
interface AuthUiComponent {
    @Provides
    @IntoSet
    fun bindsAuthPresenterFactory(factory: AuthPresenter.Factory): Presenter.Factory = factory

    @Provides
    @IntoSet
    fun bindsAuthUiFactory(factory: AuthScreenFactory): Ui.Factory = factory

    companion object
}
