package com.example.netclan_task.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.netclan_task.Screens.MyTab
import com.example.netclan_task.Screens.Personal
import com.example.netclan_task.Screens.MyBottomNav
import com.example.netclan_task.Screens.ProfileScreen
import com.example.netclan_task.Screens.RefineTopBar
import com.example.netclan_task.Screens.SettingPage
import com.example.netclan_task.Screens.Splash

@Composable
fun NavGraph(navController:NavHostController){
    NavHost(navController = navController, startDestination = Routes.Splash.routes ){
        composable(Routes.Splash.routes){
        Splash(navController = navController)
        }
//        composable(Routes.Networks.routes){
//
//        }
//        composable(Routes.Chat.routes){
//
//        }
//        composable(Routes.Groups.routes){
//
////        }
//        composable(Routes.Explore.routes){
//            MyTab()
//        }
//        composable(Routes.Contacts.routes){
//
//        }
        composable(Routes.BottomNav.routes){
            MyBottomNav(navController)
        }
        composable(Routes.Refine.routes){
            RefineTopBar(navController)
        }
        composable(Routes.Profile.routes){
            ProfileScreen(navController)
        }
        composable(Routes.Settings.routes){
            SettingPage(navController)
        }
    }
}




