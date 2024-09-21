package com.hadenlabs.jetpackcomposepokemon.ui.list

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hadenlabs.jetpackcomposepokemon.api.PokemonAPI
import com.hadenlabs.jetpackcomposepokemon.model.Pokemon

class PokemonListViewModel: ViewModel() {

    var pokemonList: List<Pokemon> by mutableStateOf(listOf())

    init {
        loadData()
    }

    private fun loadData() {

        PokemonAPI.loadPokemon({ pokemon ->
            pokemonList = pokemon
        }, {
            println("Error")
        })
    }

}