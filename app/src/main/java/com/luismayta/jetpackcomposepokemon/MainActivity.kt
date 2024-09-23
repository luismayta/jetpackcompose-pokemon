package com.luismayta.jetpackcomposepokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.luismayta.jetpackcomposepokemon.presentation.pokemonlist.PokemonListScreen
import com.luismayta.jetpackcomposepokemon.presentation.pokemonlist.PokemonListViewModel
import com.luismayta.jetpackcomposepokemon.ui.theme.JetpackComposePokemonTheme

class MainActivity : ComponentActivity() {
  private val viewModel: PokemonListViewModel by viewModels()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetpackComposePokemonTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          PokemonListScreen(viewModel)
        }
      }
    }
  }
}