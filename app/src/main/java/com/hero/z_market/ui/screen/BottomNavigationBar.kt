package com.hero.z_market.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hero.z_market.R
import com.hero.z_market.ui.theme.ZMarketTheme
import com.hero.z_market.ui.theme.selectedMenu
import com.hero.z_market.ui.theme.unselectedMenu

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Categories,
        BottomNavItem.Favorites,
        BottomNavItem.Home,
        BottomNavItem.Cart,
        BottomNavItem.MyInfo
    )
    val context = LocalContext.current

    NavigationBar(
        containerColor = White,
        contentColor = Color(0xFF3F414E)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(24.dp),
                        tint = if (currentRoute == item.screenRoute) {
                            selectedMenu
                        } else {
                            unselectedMenu
                        }
                    )
                },
                // label 선택 안했을 때도 보이는 메뉴 이름
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp,
                        color = if (currentRoute == item.screenRoute) selectedMenu else unselectedMenu
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedMenu,
                    selectedTextColor = selectedMenu,
                    indicatorColor = Color.Transparent,
                    unselectedIconColor = unselectedMenu,
                    unselectedTextColor = unselectedMenu
                ),
                selected = currentRoute == item.screenRoute,
                alwaysShowLabel = true,
                onClick = {
                    if (item != BottomNavItem.Categories) {
                        Toast.makeText(context, "${item.title} 클릭됨", Toast.LENGTH_SHORT).show()
                    }

                    navController.navigate(item.screenRoute) {
                        val startDestination = navController.graph.startDestinationRoute

                        if (startDestination != null) {
                            popUpTo(startDestination) { saveState = true }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

// 바텀 메뉴 아이템 설정
sealed class BottomNavItem(
    val title: String, val icon: Int, val screenRoute: String,
) {
    data object Categories : BottomNavItem("카테고리", R.drawable.icon_menu_categories, "CATEGORIES")
    data object Favorites : BottomNavItem("즐겨찾기", R.drawable.icon_menu_favorites, "FAVORITES")
    data object Home : BottomNavItem("홈", R.drawable.icon_menu_home, "HOME")
    data object Cart : BottomNavItem("장바구니", R.drawable.icon_menu_cart, "CART")
    data object MyInfo : BottomNavItem("나의 정보", R.drawable.icon_menu_my_info, "MY_INFO")
}

@Composable
@Preview(showBackground = true)
fun BottomNavigationBarPreview() {
    val navController = rememberNavController() // 가짜 NavHostController 생성

    ZMarketTheme {
        BottomNavigationBar(navController)
    }
}
