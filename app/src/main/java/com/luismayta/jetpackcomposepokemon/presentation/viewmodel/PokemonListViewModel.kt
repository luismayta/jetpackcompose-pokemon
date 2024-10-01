package com.luismayta.jetpackcomposepokemon.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luismayta.jetpackcomposepokemon.domain.usecase.GetPokemonDataUseCase
import com.luismayta.jetpackcomposepokemon.presentation.state.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.luismayta.jetpackcomposepokemon.core.UiState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class PokemonListViewModel @Inject constructor(
  private val pokemonListUseCase: GetPokemonDataUseCase
) : ViewModel() {

  private val _pokemonList = mutableStateOf(PokemonListState())
  val pokemonList : State<PokemonListState> get() = _pokemonList

  init {
    pokemonListUseCase.invoke().onEach {
      when(it){
        is UiState.Loading->{
          _pokemonList.value = PokemonListState(isLoading = true)
        }
        is UiState.Success->{
          _pokemonList.value = PokemonListState(data = it.data)
        }
        is UiState.Error->{
          _pokemonList.value = PokemonListState(error = it.message.toString())
        }
      }
    }.launchIn(viewModelScope)
  }

}