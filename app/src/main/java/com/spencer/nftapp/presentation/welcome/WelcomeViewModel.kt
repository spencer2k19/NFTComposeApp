package com.spencer.nftapp.presentation.welcome

import androidx.lifecycle.ViewModel
import com.spencer.nftapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(): ViewModel() {
    val slidesImages = listOf(R.drawable.intro1, R.drawable.intro2, R.drawable.intro3)

}