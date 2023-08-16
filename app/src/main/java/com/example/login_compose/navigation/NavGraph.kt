package com.example.login_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.login_compose.ui.screens.DetailScreen
import com.example.login_compose.ui.screens.LoginScreen
import com.example.login_compose.ui.screens.OtpScreen


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = ScreensRoute.Login.route
    ) {
         composable(ScreensRoute.Login.route) {
             LoginScreen(navController)
         }
        composable(ScreensRoute.Otp.route) {
            OtpScreen(navController = navController)
        }
        composable(ScreensRoute.Details.route) {
            DetailScreen()
        }
     }
}
