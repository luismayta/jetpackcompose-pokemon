package com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen

sealed interface PokemonListScreenEvents {
  data object FetchPokemon: PokemonListScreenEvents
}