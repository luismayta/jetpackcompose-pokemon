package com.luismayta.jetpackcomposepokemon.core

import com.luismayta.jetpackcomposepokemon.data.model.PokemonDTO
import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel

fun List<PokemonDTO>.toPokemonModelList(): List<PokemonModel> {
  return this.map { it.toPokemonModel() }
}

fun PokemonDTO.toPokemonModel(): PokemonModel {
  return PokemonModel(
    name = this.name,
    url = this.url
  )
}
