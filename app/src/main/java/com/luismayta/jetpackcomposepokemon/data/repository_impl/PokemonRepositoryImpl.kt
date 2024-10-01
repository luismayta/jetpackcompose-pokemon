package com.luismayta.jetpackcomposepokemon.data.repository_impl

import com.luismayta.jetpackcomposepokemon.core.toPokemonModelList
import com.luismayta.jetpackcomposepokemon.data.datasource.network.ApiService
import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel
import com.luismayta.jetpackcomposepokemon.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val apiService: ApiService) : PokemonRepository {

  override suspend fun getPokemonData(): List<PokemonModel> {
    val pokemonListDTO = apiService.getPokemonData()
    return pokemonListDTO.results?.toPokemonModelList() ?: emptyList()
  }
}