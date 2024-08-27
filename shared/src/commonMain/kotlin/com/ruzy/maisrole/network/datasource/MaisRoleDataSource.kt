package com.ruzy.maisrole.network.datasource

import com.ruzy.maisrole.network.KtorHttpClient
import com.ruzy.maisrole.network.models.AnimeDetails
import com.ruzy.maisrole.network.service.MaisRoleService
import com.ruzy.maisrole.network.util.safeApiCall
import com.ruzy.maisrole.util.ResultState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MaisRoleDataSource(
    private val api: HttpClient
) : MaisRoleService {
    override suspend fun getRandomAnime(): AnimeDetails =
        safeApiCall {
            api.get(urlString = "quotes/random").body()
        }
}