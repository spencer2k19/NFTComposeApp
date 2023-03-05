package com.spencer.nftapp.presentation.home

import com.spencer.nftapp.R

sealed class BottomNavItem(var title:String,var icon:Int,var screenRoute:String) {
    object Wallet:BottomNavItem("Wallet", R.drawable.wallet,"wallet")
    object Dex:BottomNavItem("DEX",R.drawable.search,"dex")
    object Nft:BottomNavItem("NFTs",R.drawable.nft,"nft")
    object Stats:BottomNavItem("Stats",R.drawable.chart_square_bar,"stats")
    object Profile:BottomNavItem("Profile",R.drawable.profile,"profile")

}
