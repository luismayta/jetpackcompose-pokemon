package com.luismayta.jetpackcomposepokemon.ui.screen.HomeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luismayta.jetpackcomposepokemon.domain.model.responses.ModelPokemon
import com.luismayta.jetpackcomposepokemon.domain.use_case.get_pokemon.GetPokemonDataUseCase
import com.luismayta.jetpackcomposepokemon.utils.ResourceState
import com.luismayta.jetpackcomposepokemon.ui.screen.HomeScreen.HomescreenEvents
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomescreenViewmodel(
    private val getPokemonDataUseCase: GetPokemonDataUseCase
) : ViewModel() {

    val state = MutableStateFlow<ResourceState<ModelPokemon, Exception?>>(ResourceState.Loading())

    fun onEvent(event: HomescreenEvents) = viewModelScope.launch {
        when (event) {
            HomescreenEvents.FetchPokemon -> {
                if (!state.value.isSuccess()) {
                    getPokemonDataUseCase().onEach {
                        state.value = it
                    }.launchIn(viewModelScope)
                }
            }
        }
    }

}