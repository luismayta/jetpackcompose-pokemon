package com.luismayta.jetpackcomposepokemon.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.luismayta.jetpackcomposepokemon.presentation.screen.homeScreen.HomeScreen
import com.luismayta.jetpackcomposepokemon.presentation.screen.loginScreen.LoginScreen
import com.luismayta.jetpackcomposepokemon.presentation.screen.detailScreen.DetailScreen

@Composable
fun NavigationWrapper() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = Login) {
    composable<Login> {
      LoginScreen { navController.navigate(Home) }
    }

    composable<Home> {
      HomeScreen { id -> navController.navigate(Detail(id = id)) }
    }

    composable<Detail> { backStackEntry ->
      val detail: Detail = backStackEntry.toRoute()
      DetailScreen(
        id = detail.id
      ) {
        navController.navigate(Login) {
          popUpTo<Login> { inclusive = true }
        }

      }
    }

  }
}