package com.luismayta.jetpackcomposepokemon.domain.usecase.get_pokemon

import android.util.Log
import com.luismayta.jetpackcomposepokemon.domain.repository.PokemonRepository
import com.luismayta.jetpackcomposepokemon.domain.model.responses.PokemonList
import com.luismayta.jetpackcomposepokemon.core.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetPokemonDataUseCase(private val repository: PokemonRepository) {

  operator fun invoke(): Flow<ResourceState<PokemonList, Exception?>> = flow {

    try {
      emit(ResourceState.Loading())
      val pokemonData = repository.getPokemonData()
      emit(ResourceState.Success(pokemonData))
    } catch (e: IOException) {
      Log.e("GetPokemonDataUseCase", e.stackTraceToString())
      emit(ResourceState.Failed(Exception("Couldn't reach server. Is your internet on?")))
    } catch (e: Exception) {
      Log.e("GetPokemonDataUseCase", e.stackTraceToString())
      emit(ResourceState.Failed(e))
    }

  }

}