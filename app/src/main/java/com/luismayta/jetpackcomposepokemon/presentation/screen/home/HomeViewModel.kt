package com.luismayta.jetpackcomposepokemon.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luismayta.jetpackcomposepokemon.domain.usecase.GetPokemonDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.luismayta.jetpackcomposepokemon.core.UiState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val pokemonListUseCase: GetPokemonDataUseCase
) : ViewModel() {

  private val _pokemonList = mutableStateOf(HomeState())
  val pokemonList : State<HomeState> get() = _pokemonList

  init {
    pokemonListUseCase.invoke().onEach {
      when(it){
        is UiState.Loading->{
          _pokemonList.value = HomeState(isLoading = true)
        }
        is UiState.Success->{
          _pokemonList.value = HomeState(data = it.data)
        }
        is UiState.Error->{
          _pokemonList.value = HomeState(error = it.message.toString())
        }
      }
    }.launchIn(viewModelScope)
  }

}