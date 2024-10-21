package com.luismayta.jetpackcomposepokemon.presentation.screen.home

import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel

data class HomeState(
  val isLoading: Boolean = false,
  val data: List<PokemonModel>? = null,
  var error: String = ""
)