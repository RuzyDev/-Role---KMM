package com.ruzy.maisrole.domain.interactor

import com.ruzy.maisrole.domain.Interactor
import com.ruzy.maisrole.domain.repository.MaisRoleRepository
import com.ruzy.maisrole.util.AppCoroutineDispatchers
import kotlinx.coroutines.withContext

class InsertRandomAnime(
    private val maisRoleRepository: MaisRoleRepository,
    private val dispatchers: AppCoroutineDispatchers
) : Interactor<Unit, Unit>() {

    override suspend fun doWork(params: Unit) {
        withContext(dispatchers.io) {
            maisRoleRepository.insertRandomAnime()
        }
    }
}