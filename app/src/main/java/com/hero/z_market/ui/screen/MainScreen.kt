package com.hero.z_market.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hero.z_market.ui.screen.category.CategoryListScreen
import com.hero.z_market.ui.screen.category.CategoryListTopAppBar
import com.hero.z_market.ui.viewmodel.MainViewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            val screenRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            when (screenRoute) {
                BottomNavItem.Categories.screenRoute -> {
                    CategoryListTopAppBar()
                }
            }
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = BottomNavItem.Categories.screenRoute, // 기본 시작 경로 설정,
            ) {
                composable(BottomNavItem.Categories.screenRoute) {
                    CategoryListScreen(mainViewModel)
                }
                composable(BottomNavItem.Favorites.screenRoute) {
                }
                composable(BottomNavItem.Home.screenRoute) {
                }
                composable(BottomNavItem.Cart.screenRoute) {
                }
                composable(BottomNavItem.MyInfo.screenRoute) {
                }
            }
        }
    }
}
