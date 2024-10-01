package com.luismayta.jetpackcomposepokemon.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonListDTO(
 val results: List<PokemonDTO>?
)
