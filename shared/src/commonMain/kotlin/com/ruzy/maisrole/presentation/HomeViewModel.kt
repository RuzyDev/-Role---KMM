package com.ruzy.maisrole.presentation

import com.ruzy.maisrole.domain.observers.ObserveAnimes
import com.ruzy.maisrole.presentation.util.CoroutineViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel: CoroutineViewModel(), KoinComponent {

    private val observeAnimes: ObserveAnimes by inject()

    init {
        observeAnimes(Unit)
    }
}