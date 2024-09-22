package com.hadenlabs.jetpackcomposepokemon.api

import com.hadenlabs.jetpackcomposepokemon.model.Pokemon
import com.hadenlabs.jetpackcomposepokemon.model.PokemonList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object PokemonAPI {

  fun getClient(): HttpClient {
    val client = HttpClient(CIO) {
      install(HttpTimeout) {
        socketTimeoutMillis = 60_000
        requestTimeoutMillis = 60_000
      }
      defaultRequest {
        header("Content-Type", "application/json")
        url("https://pokeapi.co/api/v2/")
      }
      install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
      }
      install(Logging) {
        level = LogLevel.ALL
      }
    }
    return client
  }

  suspend fun loadPokemon(
    success: (pokemonList: List<Pokemon>) -> Unit,
    failure: (error: String) -> Unit
  ) {

    val client = getClient()
    try {
      val response: PokemonList = client.get {
        url("pokemon")
        parameter("limit", 151)
      }.body()

      success(
        response.results ?: listOf()
      )

    } catch (e: Exception) {

      e.printStackTrace()
      failure(e.localizedMessage ?: "Error not recognized")
    } finally {
      client.close()
    }
  }

}