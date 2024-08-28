package com.ruzy.maisrole.network.service

import com.ruzy.maisrole.network.models.NetworkAnimeDetails

interface MaisRoleService {
   suspend fun getRandomAnime(): NetworkAnimeDetails
}
