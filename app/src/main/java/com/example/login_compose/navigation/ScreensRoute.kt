package com.example.login_compose.navigation

sealed class ScreensRoute(val route: String) {
    object Login: ScreensRoute("login_screen")
    object Otp: ScreensRoute("otp_screen")
    object Home: ScreensRoute("otp_screen")
    object Details: ScreensRoute("details_screen")
}