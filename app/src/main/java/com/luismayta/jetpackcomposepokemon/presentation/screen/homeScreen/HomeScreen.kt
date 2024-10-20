package com.luismayta.jetpackcomposepokemon.presentation.screen.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
  navigateToDetail:(String) -> Unit
) {
  var text by remember { mutableStateOf("") }
  Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(modifier = Modifier.weight(1f))
    Text(text = "HOME SCREEN", fontSize = 25.sp)
    Spacer(modifier = Modifier.weight(1f))
    TextField(value = text, onValueChange = {text = it})
    Spacer(modifier = Modifier.weight(1f))
    Button(onClick = { navigateToDetail(text) }) {
      Text(text = "Navegar al detalle")
    }
    Spacer(modifier = Modifier.weight(1f))
  }

}

@Preview(showSystemUi = true)
@Composable
fun HomeScreePreview(){
  return HomeScreen{}
}
