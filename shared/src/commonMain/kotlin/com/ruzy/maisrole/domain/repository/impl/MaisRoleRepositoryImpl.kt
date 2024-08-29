package com.ruzy.maisrole.domain.repository.impl

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import br.com.arcom.promocoes.db.AnimeEntity
import br.com.arcom.promocoes.db.AnimeQueries
import com.ruzy.maisrole.domain.repository.MaisRoleRepository
import com.ruzy.maisrole.model.AnimeDetails
import com.ruzy.maisrole.model.asExternalModel
import com.ruzy.maisrole.network.datasource.MaisRoleDataSource
import com.ruzy.maisrole.network.service.MaisRoleService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map

class MaisRoleRepositoryImpl(
    private val maisRoleDataSource: MaisRoleService,
    private val animeQueries: AnimeQueries
) : MaisRoleRepository {
    override suspend fun insertRandomAnime() {
        val anime = maisRoleDataSource.getRandomAnime()
        if (anime.anime.isNullOrEmpty() || anime.content.isNullOrEmpty() || anime.character.isNullOrEmpty()) {
            throw Exception("Anime not found")
        } else {
            animeQueries.insertOrUpdate(
                anime.anime,
                anime.content,
                anime.character
            )
        }
    }

    override fun observeAllAnimes(): Flow<List<AnimeDetails>> =
        animeQueries.selectAll().asFlow().mapToList(Dispatchers.IO).map {
            it.map(AnimeEntity::asExternalModel)
        }

}
