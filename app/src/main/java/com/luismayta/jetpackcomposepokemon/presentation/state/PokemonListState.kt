package com.luismayta.jetpackcomposepokemon.presentation.state

import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel

data class PokemonListState(
  val isLoading: Boolean = false,
  val data: List<PokemonModel>? = null,
  var error: String = ""
)