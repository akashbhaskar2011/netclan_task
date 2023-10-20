package com.example.netclan_task.Navigations

sealed class Routes(val routes: String) {
    object Explore:Routes(routes="Explore")
    object Chat:Routes(routes="Chat")
    object Contacts:Routes(routes="Contacts")
    object Groups:Routes(routes="Groups")
    object Networks:Routes(routes="Networks")
    object Splash:Routes(routes="Splash")
    object BottomNav:Routes(routes="BottomNav")
    object Refine:Routes(routes="Refine")
    object Profile:Routes(routes="Profile")
    object Settings:Routes(routes="Settings")
}