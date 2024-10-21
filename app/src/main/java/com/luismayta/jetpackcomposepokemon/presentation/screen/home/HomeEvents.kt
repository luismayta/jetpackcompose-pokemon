package com.luismayta.jetpackcomposepokemon.presentation.screen.home

sealed interface HomeEvents {
  data object FetchPokemon: HomeEvents
}