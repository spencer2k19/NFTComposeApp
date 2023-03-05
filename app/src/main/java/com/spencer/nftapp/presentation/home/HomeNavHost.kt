package com.spencer.nftapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.spencer.nftapp.presentation.dex.DEXView
import com.spencer.nftapp.presentation.nft.NFTView
import com.spencer.nftapp.presentation.profile.ProfileView
import com.spencer.nftapp.presentation.stats.StatsView
import com.spencer.nftapp.presentation.wallet.WalletView

@Composable
fun HomeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Nft.screenRoute) {
        composable(BottomNavItem.Nft.screenRoute) {
            NFTView()
        }

        composable(BottomNavItem.Wallet.screenRoute) {
            WalletView()
        }

        composable(BottomNavItem.Dex.screenRoute) {
            DEXView()
        }

        composable(BottomNavItem.Stats.screenRoute) {
            StatsView()
        }

        composable(BottomNavItem.Profile.screenRoute) {
            ProfileView()
        }


    }
}