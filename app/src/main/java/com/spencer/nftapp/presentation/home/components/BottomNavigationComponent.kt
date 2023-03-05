package com.spencer.nftapp.presentation.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.spencer.nftapp.presentation.home.BottomNavItem
import com.spencer.nftapp.presentation.ui.theme.Blue
import com.spencer.nftapp.presentation.ui.theme.Normal

@Composable
fun BottomNavigationComponent(navController: NavController) {
    val items = listOf(
        BottomNavItem.Wallet,
        BottomNavItem.Dex,
        BottomNavItem.Nft,
        BottomNavItem.Stats,
        BottomNavItem.Profile
    )
    
    BottomNavigation(
        contentColor = Normal,
        backgroundColor = Color.White,

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {item ->
            BottomNavigationItem(
                selected = currentRoute == item.screenRoute,
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Blue,
                unselectedContentColor = Normal,

                onClick = {
                    navController.navigate(item.screenRoute) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }




                })
            
        }

    }

}