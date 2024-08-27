package com.ruzy.maisrole.domain.repository.impl

import com.ruzy.maisrole.domain.repository.MaisRoleRepository
import com.ruzy.maisrole.network.datasource.MaisRoleDataSource

class MaisRoleRepositoryImpl(
    private val maisRoleDataSource: MaisRoleDataSource
): MaisRoleRepository {
    suspend fun getRandomAnime(){
        val anime = maisRoleDataSource.getRandomAnime()
    }
}
