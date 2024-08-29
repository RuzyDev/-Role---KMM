package com.ruzy.maisrole.presentation

import com.ruzy.maisrole.domain.interactor.InsertRandomAnime
import com.ruzy.maisrole.domain.observers.ObserveAnimes
import com.ruzy.maisrole.model.AnimeDetails
import com.ruzy.maisrole.presentation.CoroutineViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : CoroutineViewModel(), KoinComponent {

    private val observeAnimes: ObserveAnimes by inject()
    private val insertRandomAnime: InsertRandomAnime by inject()

    val uiState: StateFlow<HomeUiState> =
        combine(observeAnimes.flow, insertRandomAnime.inProgress, ::HomeUiState).stateIn(
            coroutineScope,
            SharingStarted.WhileSubscribed(5000),
            HomeUiState.Empty
        )

    fun randomAnime() {
        coroutineScope.launch {
            insertRandomAnime.invoke(Unit)
        }
    }

    init {
        observeAnimes(Unit)
    }
}

data class HomeUiState(
    val animes: List<AnimeDetails> = emptyList(),
    val loadingAnimes: Boolean = false
) {
    companion object {
        val Empty = HomeUiState()
    }
}