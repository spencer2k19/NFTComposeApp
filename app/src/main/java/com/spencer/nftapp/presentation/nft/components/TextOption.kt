package com.spencer.nftapp.presentation.nft.components

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.spencer.nftapp.presentation.ui.theme.Normal

@Composable
fun TextOption(title:String,isSelected:Boolean = false,onClick:()->Unit) {
    TextButton(onClick = {onClick()}) {
        Text(text = title, color = if (isSelected) Color.Black else Normal,
            fontSize = 15.sp,
            fontWeight = FontWeight.W700)
    }


}