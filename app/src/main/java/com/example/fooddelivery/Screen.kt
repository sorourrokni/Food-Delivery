package com.example.fooddelivery

sealed class Screen(val route:String){
    object ForgotPasswordScreen:Screen("ForgotPassword")
    object LostConnectionScreen: Screen("LostConnection")

    fun withArgs(vararg  args:String):String{
        return buildString{
            append(route)
            args.forEach {
                arg->append("/$arg")

            }
        }
    }
}