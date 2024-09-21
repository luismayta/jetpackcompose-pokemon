package com.hadenlabs.jetpackcomposepokemon.ui.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hadenlabs.jetpackcomposepokemon.ui.theme.JetpackComposePokemonTheme

class PokemonListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePokemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonList() {

    val viewModel = PokemonListViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pokémon list")
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(viewModel.pokemonList) { pokemon ->
                PokemonCell(pokemon)
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun PokemonListDefaultPreview() {
    JetpackComposePokemonTheme {
        PokemonList()
    }
}