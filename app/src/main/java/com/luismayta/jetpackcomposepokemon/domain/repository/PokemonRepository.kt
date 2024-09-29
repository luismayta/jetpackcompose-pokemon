package com.luismayta.jetpackcomposepokemon.domain.repository

import com.luismayta.jetpackcomposepokemon.domain.model.responses.PokemonList

interface PokemonRepository {
  suspend fun getPokemonData(): PokemonList
}