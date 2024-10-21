package com.luismayta.jetpackcomposepokemon.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.luismayta.jetpackcomposepokemon.presentation.screen.home.HomeScreen
import com.luismayta.jetpackcomposepokemon.presentation.screen.login.LoginScreen
import com.luismayta.jetpackcomposepokemon.presentation.screen.detail.DetailScreen

@Composable
fun NavigationWrapper() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = Login) {
    composable<Login> {
      LoginScreen { navController.navigate(Home) }
    }

    composable<Home> {
      HomeScreen { name -> navController.navigate(Detail(name = name)) }
    }

    composable<Detail> { backStackEntry ->
      val detail: Detail = backStackEntry.toRoute()
      DetailScreen(
        name = detail.name
      ) {
        navController.navigate(Login) {
          popUpTo<Login> { inclusive = true }
        }

      }
    }

  }
}