package com.quintetsolutions.qalert.navigation


//Sealed class provides type safety, compile time checks,
// (Sealed classes provide a limited set of possible values (subclasses)
//code is more organized and readable

sealed class Screens(val route: String) {
    object Login : Screens(route = "login_screen")
    object Otp : Screens(route = "otp_screen")
    object Home : Screens(route = "home_screen")
    object Detail : Screens(route = "detail_screen")
}



