package com.luismayta.jetpackcomposepokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen.PokemonListScreen
import com.luismayta.jetpackcomposepokemon.ui.theme.JetpackComposePokemonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetpackComposePokemonTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          PokemonListScreen()
        }
      }
    }
  }
}