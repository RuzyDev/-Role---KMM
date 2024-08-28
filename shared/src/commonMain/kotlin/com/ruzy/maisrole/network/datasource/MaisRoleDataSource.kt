package com.ruzy.maisrole.network.datasource

import com.ruzy.maisrole.network.models.NetworkAnimeDetails
import com.ruzy.maisrole.network.service.MaisRoleService
import com.ruzy.maisrole.network.util.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class MaisRoleDataSource(
    private val api: HttpClient
) : MaisRoleService {
    override suspend fun getRandomAnime(): NetworkAnimeDetails =
        safeApiCall {
            api.get(urlString = "quotes/random"){
                contentType(ContentType.Application.Json)
            }.body()
        }
}