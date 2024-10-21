package com.luismayta.jetpackcomposepokemon.domain.model
import com.luismayta.jetpackcomposepokemon.core.Constants

data class PokemonModel(val name: String, val url: String) {
    val id: Int
        get() {
            val components = url.split("/")
            return components[components.size - 2].toIntOrNull() ?: 0
        }

    val imageUrl: String
        get() =  "${Constants.Endpoints.IMAGES_URL}/${id}.png"
}