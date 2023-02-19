package com.spencer.nftapp.presentation.welcome

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spencer.nftapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(): ViewModel() {

    var slidesImage = listOf(R.drawable.intro1, R.drawable.intro2, R.drawable.intro3)
    val titles = listOf("Create Collects,\n" +
            "Timeless Artworks","Scure Your Assets\n" +
            "with the good one "," Variety of\n" +
            "cryptocurrency wallet")

    val descriptions = listOf("The world’s largest digital marketplace for crypto collectibles and non-fungible tokens. Buy, sell, and discover exclusive digital items.",
    "OKNFT has partnered with some notable companies\u2028and recently partnered with we to help secure \u2028non-fungible tokens artists' and creators' work.",
    "Supports more than 150 cryptocurrency wallet. For an introduction to the non-fungible tokens world, OKNFT\u2028is a great place to start.")






}