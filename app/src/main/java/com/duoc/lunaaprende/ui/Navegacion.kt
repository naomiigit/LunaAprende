package com.duoc.lunaaprende.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duoc.lunaaprende.ui.theme.PaginaUno

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "paginaUno") {
        composable("paginaUno") { PaginaUno(navController) }
        composable("paginaDos") { PaginaDos(navController) }
    }
}