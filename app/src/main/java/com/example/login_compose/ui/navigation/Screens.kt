package com.example.login_compose.ui.navigation

sealed class Screens(val route: String) {
    object Login : Screens("Login_screen")
    object Otp: Screens("Otp_screen")
    object Home : Screens("Home_screen")
    object Detail : Screens("Detail_screen")
}
