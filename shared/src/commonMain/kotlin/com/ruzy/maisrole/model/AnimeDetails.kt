package com.ruzy.maisrole.model

import br.com.arcom.promocoes.db.AnimeEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class AnimeDetails(
    val anime: String? = null,
    val character: String? = null,
    val content: String? = null
)

fun AnimeEntity.asExternalModel() = AnimeDetails(
    anime = anime,
    character = character,
    content = content,
)