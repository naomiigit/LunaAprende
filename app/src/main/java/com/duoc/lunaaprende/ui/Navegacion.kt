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
    val navController = rememberNavController()
    val ivm: InicioViewModel = viewModel()
    val rvm: RegistroViewModel = viewModel()
    val qvm: QuizViewModel = viewModel()

    NavHost(navController, startDestination = "Inicio") {
        composable("Inicio") { Inicio(ivm, navController) }
        composable("Registro") {Registro(rvm,navController)}
        composable("menu") { Menu(navController) }
        composable("Quiz") { Quiz(navController,qvm) }
        composable("SubirApunte") {SubirApunte(navController)}
    }
}
