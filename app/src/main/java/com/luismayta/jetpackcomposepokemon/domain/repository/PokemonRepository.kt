package com.luismayta.jetpackcomposepokemon.domain.repository

import com.luismayta.jetpackcomposepokemon.domain.model.PokemonListModel
import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel

interface PokemonRepository {
  suspend fun getPokemonData(): List<PokemonModel>
}