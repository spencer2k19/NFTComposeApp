package com.spencer.nftapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spencer.nftapp.presentation.ui.theme.Blue

@Composable
fun CustomFilledButton(
    text:String,
    onClick:()->Unit,
    color: Color = Blue,
    textColor: Color = Color.White

) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .height(50.dp)


    ) {
        Text(text = text, color = textColor)
    }
}

@Preview
@Composable
fun PrevFilledButton() {
    CustomFilledButton(text = "Test", onClick = {})
}