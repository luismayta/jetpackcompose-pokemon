package com.luismayta.jetpackcomposepokemon.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.luismayta.jetpackcomposepokemon.presentation.components.ErrorView
import com.luismayta.jetpackcomposepokemon.presentation.components.LoadingView
import com.luismayta.jetpackcomposepokemon.presentation.screen.home.components.PokemonListView

@Composable
fun HomeScreen(
  viewModel: HomeViewModel = hiltViewModel(),
  navigateToDetail: (String) -> Unit
) {
  val result = viewModel.pokemonList.value
  Column(
    modifier = Modifier
      .fillMaxSize()
  ) {
    when {
      result.isLoading -> {
        LoadingView(modifier = Modifier.fillMaxSize())
      }

      result.data != null -> {
        PokemonListView(pokemonList = result.data,
          onClick = { pokemon ->
            navigateToDetail(pokemon.name)
          }
        )
      }

      result.error.isNotEmpty() -> {
        ErrorView(error = result.error, modifier = Modifier.fillMaxSize())
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreePreview() {
  return HomeScreen {}
}
