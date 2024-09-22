package com.hadenlabs.jetpackcomposepokemon.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hadenlabs.jetpackcomposepokemon.ui.theme.JetpackComposePokemonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(viewModel: PokemonListViewModel = viewModel()) {
  val pokemonList by viewModel.pokemonList.collectAsState()
  val isError by viewModel.isError.collectAsState()

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text("Pokémon list")
        }
      )
    }
  ) { padding ->
    if (isError) {
      Text(
        text = "Error loading Pokémon",
        color = MaterialTheme.colorScheme.error,
        modifier = Modifier.padding(padding)
      )
    } else {
      LazyColumn(
        modifier = Modifier.padding(padding)
      ) {
        items(pokemonList) { pokemon ->
          PokemonCell(pokemon)
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
