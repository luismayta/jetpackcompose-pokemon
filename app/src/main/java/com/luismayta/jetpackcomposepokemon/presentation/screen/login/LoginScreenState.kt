package com.luismayta.jetpackcomposepokemon.presentation.screen.login

import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel

data class LoginScreenState (
  val isLoading: Boolean = false,
  val data: List<PokemonModel>? = null,
  var error: String = ""
)