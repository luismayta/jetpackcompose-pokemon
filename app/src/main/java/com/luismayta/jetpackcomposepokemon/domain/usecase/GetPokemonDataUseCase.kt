package com.luismayta.jetpackcomposepokemon.domain.usecase

import com.luismayta.jetpackcomposepokemon.core.UiState
import com.luismayta.jetpackcomposepokemon.data.repository_impl.PokemonRepositoryImpl
import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetPokemonDataUseCase @Inject constructor(private val repositoryImpl: PokemonRepositoryImpl) {

  operator fun invoke(): Flow<UiState<List<PokemonModel>>> = flow {
    emit(UiState.Loading<List<PokemonModel>>(data = null))
    try {
      val data = repositoryImpl.getPokemonData()
      emit(UiState.Success(data = data))
    } catch (e: ClientRequestException) {
      emit(UiState.Error<List<PokemonModel>>(data = null, message = "Request error: ${e.message}"))
    } catch (e: ServerResponseException) {
      emit(UiState.Error<List<PokemonModel>>(data = null, message = "Server error: ${e.message}"))
    } catch (e: IOException) {
      emit(UiState.Error<List<PokemonModel>>(data = null, message = "Network error: ${e.message}"))
    } catch (e: Exception) {
      emit(UiState.Error<List<PokemonModel>>(data = null, message = e.message.toString()))
    }
  }.flowOn(Dispatchers.IO)

}
