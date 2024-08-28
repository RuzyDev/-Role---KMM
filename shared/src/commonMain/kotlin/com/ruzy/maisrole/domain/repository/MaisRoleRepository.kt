package com.ruzy.maisrole.domain.repository

import com.ruzy.maisrole.model.AnimeDetails
import kotlinx.coroutines.flow.Flow

interface MaisRoleRepository {

    suspend fun insertRandomAnime()
    fun observeAllAnimes(): Flow<List<AnimeDetails>>
}
