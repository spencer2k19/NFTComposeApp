package com.spencer.nftapp.presentation.verify_identity

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.spencer.nftapp.R
import com.spencer.nftapp.presentation.components.BackButton
import com.spencer.nftapp.presentation.components.CustomFilledButton
import com.spencer.nftapp.presentation.components.CustomOutlinedTextField
import com.spencer.nftapp.presentation.main.ConfirmIdentity
import com.spencer.nftapp.presentation.main.CreatePinCode
import com.spencer.nftapp.presentation.ui.theme.Normal

@Composable
fun VerifyIdentityView(
    navController: NavController? = null

) {
    var phone by remember { mutableStateOf("") }

    Scaffold(topBar = {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = 20.dp
            )) {


         BackButton{
             navController?.navigateUp()
         }
        }
    }) {
        Column(
            horizontalAlignment = Alignment.Start
            ,modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(vertical = 10.dp, horizontal = 20.dp)) {
            Text(text = stringResource(id = R.string.enter_phone), fontSize = 24.sp,
            fontWeight = FontWeight.W700
                )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "We're going to send you a verification code to confirm your identity",
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Normal
                )


            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "Verification Code",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )

            Spacer(modifier = Modifier.height(10.dp))
            
            CustomOutlinedTextField(text = phone, onValueChange = {
                                                                  phone = it
            } , placeHolder ="Enter a phone number",
            keyboardType = KeyboardType.Phone,

                )



            Spacer(modifier = Modifier.height(60.dp))


            CustomFilledButton(text = "Send Code",
                onClick = {
                    navController?.navigate(CreatePinCode.route)
                })






        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewVerifyIdentity() {
    VerifyIdentityView()
}