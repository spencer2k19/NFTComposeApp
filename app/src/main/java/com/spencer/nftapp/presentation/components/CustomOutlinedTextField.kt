package com.spencer.nftapp.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomOutlinedTextField(text:String,
                            onValueChange:(text:String)->Unit,
                            placeHolder:String,
                            keyboardType: KeyboardType = KeyboardType.Text,
                            leadingIcon:@Composable (()->Unit)? = null,
                            trailingIcon:@Composable (()->Unit)? = null,
                            obscureText:Boolean = false) {
    OutlinedTextField(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .border(1.dp, Color(0xFFD9D9D9)),
        value = text,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if(obscureText) PasswordVisualTransformation() else VisualTransformation.None,
        placeholder = {
            Text(text = placeHolder,
                color = Color(0xFF475569),
                modifier = Modifier.padding(
                    start = 5.dp
                ),
                fontSize = 14.sp

            )
        },
        leadingIcon =  leadingIcon,
        trailingIcon = trailingIcon,

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(3.dp),

        )
}