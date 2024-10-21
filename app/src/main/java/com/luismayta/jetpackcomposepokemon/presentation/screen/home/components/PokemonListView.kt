package com.luismayta.jetpackcomposepokemon.presentation.screen.home.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel

@Composable
fun PokemonListView(pokemonList: List<PokemonModel>, onClick: (PokemonModel) -> Unit) {
  LazyColumn {
    items(pokemonList) { pokemon ->
      PokemonCell(pokemon = pokemon, onClick = onClick)

    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun PokemonListPreview() {
  val dataPokemonList = listOf(
    PokemonModel(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
    PokemonModel(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
    PokemonModel(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
    PokemonModel(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
    PokemonModel(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
  )
  PokemonListView(pokemonList = dataPokemonList, onClick = { it -> println("Clicked on ${it.name}") })
}