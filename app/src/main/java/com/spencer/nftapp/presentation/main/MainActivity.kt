package com.spencer.nftapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.spencer.nftapp.presentation.ui.theme.NFTAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           NftApp()
        }
    }
}



@ExperimentalPagerApi
@Composable
fun NftApp() {
    NFTAppTheme() {
        val navController = rememberNavController()
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            color = MaterialTheme.colors.background
        ) {
            NftNavHost(navController = navController)
        }
    }
}



@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NFTAppTheme() {
        NftApp()
    }
}