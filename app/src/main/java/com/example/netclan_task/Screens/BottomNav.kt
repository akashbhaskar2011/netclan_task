package com.example.netclan_task.Screens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.netclan_task.Model.BottomNavItem
import com.example.netclan_task.Navigations.Routes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.netclan_task.Items.NavDrawerItem
import com.example.netclan_task.Model.DrawerItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomNav(navController :NavHostController) {
    val navController1= rememberNavController()
    Scaffold (
        topBar = {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        ModalNavigationDrawer(
            modifier = Modifier.zIndex(1f),
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet { NavDrawerItem()}
            },
        ){MyTopBar(navController,scope,drawerState)}
    },
        bottomBar = {MyBottomBar(navController1)}){innerPadding ->
    NavHost(navController = navController1, startDestination = Routes.Explore.routes,
        modifier = Modifier.padding(innerPadding))   {
        composable(route = Routes.Explore.routes){
            Explore(navController)
        }
        composable(route = Routes.Chat.routes){

        }
        composable(route = Routes.Chat.routes){

        }
        composable(route = Routes.Chat.routes){

        }
    }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navController: NavHostController, scope: CoroutineScope, drawerState: DrawerState) {

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text("Howdy akash bhaskar!!\nBomanhalli", textAlign = TextAlign.Justify)
        },

        navigationIcon = {
            IconButton(onClick = {

                scope.launch {
                    drawerState.apply {
                        if(isClosed) open() else close()
                    }
                }
            }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = {
                navController.navigate(Routes.Refine.routes){
                    popUpTo("explore") {
                        inclusive = true
                    }
                }

            }) {
                Column {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Localized description",

                        )
                    Text(text = "refine")
                }
            }

        }

    )
}

// This is comment on dummy  branch
@Composable
fun MyBottomBar(navController1: NavHostController){
    val backStackEntry=navController1.currentBackStackEntryAsState()
    val list=listOf(
        BottomNavItem(title="Explore",routes=Routes.Explore.routes, Icons.Rounded.Home),
        BottomNavItem(title="Chat",routes=Routes.Chat.routes, Icons.Rounded.AccountBox),
        BottomNavItem(title="Chat",routes=Routes.Chat.routes, Icons.Rounded.AccountBox),
        BottomNavItem(title="Chat",routes=Routes.Chat.routes, Icons.Rounded.AccountBox),
        BottomNavItem(title="Chat",routes=Routes.Chat.routes, Icons.Rounded.AccountBox),
    )
    BottomAppBar{
        list.forEach{
            val selected:Boolean=it.routes==backStackEntry?.value?.destination?.route
            NavigationBarItem(selected = selected,
                onClick = {
                    navController1.navigate(it.routes){
                        popUpTo(navController1.graph.findStartDestination().id){
                            saveState=true
                        }
                        launchSingleTop=true
                    }
                }, icon = {
                    Column {
                        Icon(imageVector = it.icon, contentDescription =it.title )
                        Text(text = it.title)
                    }

                })
        }
    }
}