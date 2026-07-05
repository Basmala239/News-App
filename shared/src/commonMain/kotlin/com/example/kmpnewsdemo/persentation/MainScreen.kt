package com.example.kmpnewsdemo.persentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun NewsApp(newsViewModel: NewsViewModel, favoritesViewModel: FavoritesViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentRoute == Routes.HOME,
                    onClick = { navController.navigate(Routes.HOME) },
                    label = { Text("News") },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) }
                )
                NavigationBarItem(
                    selected = currentRoute == Routes.FAVORITES,
                    onClick = { navController.navigate(Routes.FAVORITES) },
                    label = { Text("Favorites") },
                    icon = { Icon(Icons.Default.Favorite, contentDescription = null) }
                )
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(padding)
        ) {
            composable(Routes.HOME) { HomeScreen(newsViewModel) }
            composable(Routes.FAVORITES) { FavoritesScreen(favoritesViewModel) }
        }
    }
}