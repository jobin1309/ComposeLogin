package com.example.login_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.login_compose.ui.detail.DetailScreen
import com.example.login_compose.ui.home.HomeScreen
import com.example.login_compose.ui.login.LoginScreen
import com.example.login_compose.ui.login.Otp
import com.example.login_compose.ui.login.OtpScreen


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.Login.route) {

        composable(route = Screens.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.Otp.route) {
            OtpScreen(navController = navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.Detail.route) {
            DetailScreen(navController = navController)
        }
    }
}



