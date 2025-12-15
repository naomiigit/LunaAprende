package com.duoc.lunaaprende.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.duoc.lunaaprende.data.local.Session
import com.duoc.lunaaprende.ui.theme.Inicio

import com.duoc.lunaaprende.viewmodel.InicioViewModel
import com.duoc.lunaaprende.viewmodel.QuizViewModel
import com.duoc.lunaaprende.viewmodel.RegistroViewModel

@Composable
fun Navegacion() {
    val nav = rememberNavController()

    val context = LocalContext.current
    val session = Session(context)

    val start = if (session.isLoggedIn()) "Menu" else "Inicio"

    NavHost(navController = nav, startDestination = start) {

        composable("Inicio") {
            val ivm: InicioViewModel = viewModel()
            Inicio(ivm, nav)
        }

        composable("Registro") {
            val rvm: RegistroViewModel = viewModel()
            Registro(rvm, nav)
        }

        composable("Menu") { Menu(nav) }

        composable("SubirApunte") { SubirApunte(nav) }

        composable("Dificultad") { Dificultad(nav) }

        composable(
            route = "Quiz/{difficulty}",
            arguments = listOf(navArgument("difficulty") { type = NavType.StringType })
        ) { backStackEntry ->
            val difficulty = backStackEntry.arguments?.getString("difficulty") ?: "Facil"
            val qvm: QuizViewModel = viewModel()
            Quiz(nav, qvm, difficulty)
        }
    }
}
