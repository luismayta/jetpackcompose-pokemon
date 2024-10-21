package com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen.components.ErrorView
import com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen.components.LoadingView
import com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen.components.PokemonListView
import com.luismayta.jetpackcomposepokemon.presentation.viewmodel.PokemonListViewModel
import com.luismayta.jetpackcomposepokemon.ui.theme.JetpackComposePokemonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
  viewModel: PokemonListViewModel = hiltViewModel()
) {
  val result = viewModel.pokemonList.value

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text("Pokémon list")
        }
      )
    }
  ) { padding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding)
    ) {
      when {
        result.isLoading -> {
          LoadingView(modifier = Modifier.fillMaxSize())
        }
        result.data != null -> {
          PokemonListView(pokemonList = result.data)
        }
        result.error.isNotEmpty() -> {
          ErrorView(error = result.error, modifier = Modifier.fillMaxSize())
        }
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun PokemonListDefaultPreview() {
  JetpackComposePokemonTheme {
    PokemonListScreen()
  }
}
