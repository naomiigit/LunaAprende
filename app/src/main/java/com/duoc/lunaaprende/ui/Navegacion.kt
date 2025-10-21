package com.duoc.lunaaprende.ui


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duoc.lunaaprende.ui.theme.Inicio
import com.duoc.lunaaprende.viewmodel.InicioViewModel
import com.duoc.lunaaprende.viewmodel.RegistroViewModel
import com.duoc.lunaaprende.viewmodel.QuizViewModel

@Composable
fun Navegacion() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = "Inicio") {

        composable("Inicio") {
            val ivm: InicioViewModel = viewModel()
            Inicio(ivm, nav)
        }

        composable("Registro") {
            val rvm: RegistroViewModel = viewModel()
            Registro(rvm, nav)
        }

        composable("Menu") {
            Menu(nav)
        }

        composable("Quiz") {
            val qvm: QuizViewModel = viewModel()
            Quiz(nav, qvm)
        }

        composable("SubirApunte") {
            SubirApunte(nav)
        }
    }
}
