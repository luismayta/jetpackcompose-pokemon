package com.luismayta.jetpackcomposepokemon.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO(val name: String, val url: String) {
  val id: Int
    get() {
      val components = url.split("/")
      return components[components.size - 2].toIntOrNull() ?: 0
    }

  val imageUrl: String
    get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}