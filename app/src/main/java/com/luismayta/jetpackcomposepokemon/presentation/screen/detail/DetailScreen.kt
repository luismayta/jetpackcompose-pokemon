package com.luismayta.jetpackcomposepokemon.presentation.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(
  name: String, navigateBack: () -> Unit
) {
  Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(modifier = Modifier.weight(1f))
    Text(text = "pokemon detail $name", fontSize = 25.sp)
    Spacer(modifier = Modifier.weight(1f))
    Button(onClick = { navigateBack() }) {
      Text(text = "Logout")
    }
    Spacer(modifier = Modifier.weight(1f))
  }
}

@Preview(showSystemUi = true)
@Composable
fun PokemonDetailPreview() {
  DetailScreen(name = "bulbasaur") { }
}