package com.ruzy.maisrole.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NetworkAnimeDetails (
  @SerialName("anime"     ) val anime     : String? = null,
  @SerialName("character" ) val character : String? = null,
  @SerialName("content"   ) val content   : String? = null
)