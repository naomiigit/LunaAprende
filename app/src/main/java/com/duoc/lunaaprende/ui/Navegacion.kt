package com.duoc.lunaaprende.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duoc.lunaaprende.ui.theme.Inicio
import com.duoc.lunaaprende.viewModel.InicioViewModel
import com.duoc.lunaaprende.viewModel.RegistroViewModel


@Composable
fun Navegacion() {
    val navController = rememberNavController()
    val ivm: InicioViewModel = viewModel()
    val rvm: RegistroViewModel = viewModel()
    NavHost(navController, startDestination = "Inicio") {
        composable("Inicio") { Inicio(ivm, navController) }
        composable("Registro") {Registro(rvm,navController)}
    }
}
