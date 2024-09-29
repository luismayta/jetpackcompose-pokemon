package com.luismayta.jetpackcomposepokemon.di.module

import android.util.Log
import com.luismayta.jetpackcomposepokemon.core.Constants
import com.luismayta.jetpackcomposepokemon.data.datasource.remote.PokemonAPI
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header

import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object ApiModule {

  @Singleton
  @Provides
  fun provideHttpClient(): HttpClient {
    return HttpClient(CIO) {
      install(Logging) {
        level = LogLevel.ALL
      }

      install(Logging) {
        logger = object : Logger {
          override fun log(message: String) {
            Log.v("Logger Ktor =>", message)
          }

        }
        level = LogLevel.ALL
      }
      install(DefaultRequest) {
        url(Constants.Endpoints.ENDPOINT)
        header(HttpHeaders.ContentType, ContentType.Application.Json)
      }
      install(ContentNegotiation) {
        json(Json {
          prettyPrint = true
          isLenient = true
          ignoreUnknownKeys = true
        })
      }
    }
  }

  @Singleton
  @Provides
  fun providePokemonApi(httpClient: HttpClient): PokemonAPI {
    return PokemonAPI(httpClient = httpClient)
  }

}