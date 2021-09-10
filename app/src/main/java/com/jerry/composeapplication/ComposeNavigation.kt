package com.jerry.composeapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jerry.composeapplication.ui.Main

/**
 * Created by Jerry  on 2021/5/20 10:21
 * Describe
 */
@Composable
fun ComposeNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination ="main"){
        composable("main"){
            Main(navController)
        }
    }
}