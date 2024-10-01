package com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen.components.PokemonCell
import com.luismayta.jetpackcomposepokemon.presentation.viewmodel.PokemonListViewModel
import com.luismayta.jetpackcomposepokemon.ui.theme.JetpackComposePokemonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
  viewModel: PokemonListViewModel = hiltViewModel()
) {
  val context  = LocalContext.current
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
    Column(modifier = Modifier
      .fillMaxSize()
      .padding(padding)) {

      if (result.isLoading) {
        Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          CircularProgressIndicator(modifier = Modifier.size(50.dp))
        }
      }

      result.data?.let {
        Column(modifier = Modifier.fillMaxSize()) {
          LazyColumn {
            items(it) { pokemon ->
              PokemonCell(pokemon)
            }
          }
        }
      }

      if (result.error.isNotEmpty()) {
        Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          Text(text = result.error.toString())
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
