package com.luismayta.jetpackcomposepokemon.domain.di

import com.luismayta.jetpackcomposepokemon.data.repository_impl.PokemonRepositoryImpl
import com.luismayta.jetpackcomposepokemon.domain.usecase.GetPokemonDataUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

  @Provides
  @Singleton
  fun providePokemonListUseCase(repositoryImpl: PokemonRepositoryImpl) : GetPokemonDataUseCase{
    return GetPokemonDataUseCase(repositoryImpl)
  }
}