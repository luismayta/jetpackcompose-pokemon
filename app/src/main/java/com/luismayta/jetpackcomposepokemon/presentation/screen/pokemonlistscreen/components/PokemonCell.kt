package com.luismayta.jetpackcomposepokemon.presentation.screen.pokemonlistscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.luismayta.jetpackcomposepokemon.domain.model.PokemonModel


@Composable
fun PokemonCell(pokemon: PokemonModel) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        AsyncImage(
            model = pokemon.imageUrl,
            "Pokémon image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(8.dp)
        )
        Text(
            "#${pokemon.id}",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            pokemon.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.fillMaxWidth())
    }

}