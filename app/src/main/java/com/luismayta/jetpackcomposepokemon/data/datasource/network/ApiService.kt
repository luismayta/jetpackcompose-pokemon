package com.luismayta.jetpackcomposepokemon.data.datasource.network

import com.luismayta.jetpackcomposepokemon.core.Constants
import com.luismayta.jetpackcomposepokemon.data.model.PokemonListDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import javax.inject.Inject

class ApiService @Inject constructor(
  private val httpClient: HttpClient
) {

  suspend fun getPokemonData(): PokemonListDTO = httpClient.get(Constants.Endpoints.ENDPOINT) {

    accept(ContentType.Application.Json)
    url {
      appendPathSegments(Constants.Endpoints.POKEMON)
      parameters.append(Constants.Endpoints.PAGE_SIZE, "20")
    }
  }.body()

}