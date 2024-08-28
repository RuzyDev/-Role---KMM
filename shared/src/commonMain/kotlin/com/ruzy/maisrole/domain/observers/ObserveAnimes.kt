package com.ruzy.maisrole.domain.observers

import com.ruzy.maisrole.domain.Interactor
import com.ruzy.maisrole.domain.SubjectInteractor
import com.ruzy.maisrole.domain.repository.MaisRoleRepository
import com.ruzy.maisrole.model.AnimeDetails
import com.ruzy.maisrole.util.AppCoroutineDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ObserveAnimes(
    private val maisRoleRepository: MaisRoleRepository
) : SubjectInteractor<Unit, List<AnimeDetails>>() {

    override fun createObservable(params: Unit): Flow<List<AnimeDetails>> {
        return maisRoleRepository.observeAllAnimes()
    }
}