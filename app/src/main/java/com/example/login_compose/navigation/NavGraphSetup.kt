package com.quintetsolutions.qalert.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.login_compose.ui.detail.DetailScreen
import com.example.login_compose.ui.home.HomeScreen
import com.example.login_compose.ui.login.LoginScreen
import com.example.login_compose.ui.login.OTPScreen


@Composable
fun NavGraphSetup(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    ) {
        composable(Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(Screens.Otp.route) {
            OTPScreen(navController)
        }
        composable(Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(Screens.Detail.route) {
            DetailScreen(navController)
        }
    }
}