package com.spencer.nftapp.presentation.register

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.spencer.nftapp.R
import com.spencer.nftapp.presentation.components.*
import com.spencer.nftapp.presentation.main.CreatePinCode
import com.spencer.nftapp.presentation.main.Login
import com.spencer.nftapp.presentation.ui.theme.Blue
import com.spencer.nftapp.presentation.ui.theme.Normal

@Composable
fun CreatePinView(navController:NavController? = null) {
    var otpValue by remember { mutableStateOf("") }
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
            ,modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)) {
            Text(text = stringResource(id = R.string.create_pin_code), fontSize = 24.sp,
                fontWeight = FontWeight.W700
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = stringResource(id = R.string.pin_code_description),
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Normal
            )


            Spacer(modifier = Modifier.height(30.dp))

            PinView(pinText = otpValue, onPinTextChange = {
                otpValue = it
            }, digitColor = Blue, digitSize = 24.sp)



            Spacer(modifier = Modifier.height(30.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.dont_receive_code),
                fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Normal
                    )
                Spacer(modifier = Modifier.width(5.dp))

                Text(text = stringResource(R.string.resend_please),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = Blue
                )

            }

            Spacer(modifier = Modifier.height(60.dp))


            CustomFilledButton(text = "Validate",
                onClick = {
                    navController?.popBackStack(route = Login.route,inclusive = false)

                })








        }
    }
}



@Preview
@Composable
fun DefaultCreatePinView() {
    CreatePinView()
}