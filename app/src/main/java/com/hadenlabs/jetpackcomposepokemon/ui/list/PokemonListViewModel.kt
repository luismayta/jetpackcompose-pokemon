package com.hadenlabs.jetpackcomposepokemon.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadenlabs.jetpackcomposepokemon.api.PokemonAPI
import com.hadenlabs.jetpackcomposepokemon.model.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {
  private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
  val pokemonList: StateFlow<List<Pokemon>> get() = _pokemonList

  private val _isError = MutableStateFlow<Boolean>(false)
  val isError: StateFlow<Boolean> get() = _isError

  init {
    loadData()
  }

  private fun loadData() {
    viewModelScope.launch {
      PokemonAPI.loadPokemon({ pokemon ->
        _pokemonList.value = pokemon
        _isError.value = false
      }, {
        _isError.value = true
      })
    }
  }
}