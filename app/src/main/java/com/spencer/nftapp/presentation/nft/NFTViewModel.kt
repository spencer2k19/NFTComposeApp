package com.spencer.nftapp.presentation.nft

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NFTViewModel @Inject constructor():ViewModel() {
    private val _currentOptionIndex = mutableStateOf(0)
    val currentOptionIndex:State<Int> = _currentOptionIndex

    fun setCurrentOption(index:Int) {
        _currentOptionIndex.value = index
    }


}