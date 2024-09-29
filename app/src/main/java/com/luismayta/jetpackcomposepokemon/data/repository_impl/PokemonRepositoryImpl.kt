package com.luismayta.jetpackcomposepokemon.data.repository_impl

import com.luismayta.jetpackcomposepokemon.data.datasource.remote.PokemonApi
import com.luismayta.jetpackcomposepokemon.domain.repository.PokemonRepository
import com.luismayta.jetpackcomposepokemon.domain.model.responses.PokemonList

class PokemonRepositoryImpl(val api: PokemonApi): PokemonRepository {
    override suspend fun getPokemonData(): PokemonList {
        return api.getPokemonData()
    }
}