package com.ruzy.maisrole.network.service

import com.ruzy.maisrole.network.models.AnimeDetails
import com.ruzy.maisrole.util.ResultState

interface MaisRoleService {
   suspend fun getRandomAnime(): AnimeDetails
}
