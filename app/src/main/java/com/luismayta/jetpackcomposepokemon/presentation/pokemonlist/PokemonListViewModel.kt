package com.luismayta.jetpackcomposepokemon.presentation.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luismayta.jetpackcomposepokemon.data.datasource.remote.PokemonAPI
import com.luismayta.jetpackcomposepokemon.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
  private val pokemonClient: PokemonAPI
) : ViewModel() {

  private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
  val pokemonList: StateFlow<List<Pokemon>> get() = _pokemonList

  private val _isError = MutableStateFlow<Boolean>(false)
  val isError: StateFlow<Boolean> get() = _isError

  init {
    fetchPokemon()
  }

  private fun fetchPokemon() {
    viewModelScope.launch {
      try {
        val pokemonData = pokemonClient.getPokemonData()
        _pokemonList.value = pokemonData.results?.map { pokemon ->
          Pokemon(
                name = pokemon.name,
                url = pokemon.url
          )
        } ?: emptyList()
      } catch (e: Exception) {
        _pokemonList.value = emptyList()
        _isError.value = true
      }
    }
  }

  /*private fun loadData() {
    viewModelScope.launch {
      pokemonClient.getPokemonData({ pokemon ->
        _pokemonList.value = pokemon
        _isError.value = false
      }, {
        _isError.value = true
      })
    }
  }*/
}