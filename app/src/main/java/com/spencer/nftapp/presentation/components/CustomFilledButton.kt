package com.spencer.nftapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.unit.dp

@Composable
fun CustomFilledButton(
    text:String,
    onClick:()->Unit,
    color: Color = Blue,
    textColor: Color = Color.White

) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(3.dp)
            )

    ) {
        Text(text = text, color = textColor)
    }
}