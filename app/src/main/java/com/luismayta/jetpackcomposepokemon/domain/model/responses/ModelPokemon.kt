package com.luismayta.jetpackcomposepokemon.domain.model.responses

import com.luismayta.jetpackcomposepokemon.core.Constants
import kotlinx.serialization.Serializable

@Serializable
data class PokemonList(
  val count: Int? = null,
  val results: List<Pokemon>? = null,
  val next: String? = "",
  val previous: String? = "",
)

@Serializable
data class Pokemon(val name: String, val url: String) {
  val id: Int
    get() {
      val components = url.split("/")
      return components[components.size - 2].toIntOrNull() ?: 0
    }

  val imageUrl: String
    get() = "${Constants.Endpoints.IMAGES_URL}/${id}.png"
}