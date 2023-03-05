package com.spencer.nftapp.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.spencer.nftapp.presentation.home.components.BottomNavigationComponent
import com.spencer.nftapp.presentation.main.NftNavHost
import com.spencer.nftapp.presentation.ui.theme.NFTAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreenView()
        }
    }
}

@Composable
fun HomeScreenView(){
    NFTAppTheme() {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomNavigationComponent(navController = navController) }
        ) {

            HomeNavHost(navController = navController)
        }
    }

}

@Preview
@Composable
fun PreviewHomeScreenView() {
    HomeScreenView()
}

