package com.luismayta.jetpackcomposepokemon.domain.model

data class PokemonListModel(
  val count: Int? = null,
  val results: List<PokemonModel>? = null,
  val next: String? = "",
  val previous: String? = "",
)