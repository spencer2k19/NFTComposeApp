package com.spencer.nftapp.presentation.reset_password

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
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
import com.spencer.nftapp.presentation.components.BackButton
import com.spencer.nftapp.presentation.components.CustomFilledButton
import com.spencer.nftapp.presentation.components.CustomOutlinedTextField
import com.spencer.nftapp.presentation.main.CreatePinCode
import com.spencer.nftapp.presentation.ui.theme.Normal

@Composable
fun ResetPasswordView(
    navController: NavController? = null
) {
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

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
            Text(text = stringResource(id = R.string.reset_password), fontSize = 24.sp,
                fontWeight = FontWeight.W700
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = stringResource(R.string.reset_password_description),
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Normal
            )


            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "Password",
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Normal

            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = password, onValueChange = {
                password = it
            } , placeHolder ="Enter a password",
                obscureText = true,
                keyboardType = KeyboardType.Password,
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                }

                )

            Spacer(modifier = Modifier.height(30.dp))

            Text(text = stringResource(R.string.confirm_password),
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Normal

                )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = password, onValueChange = {
                password = it
            } , placeHolder ="Confirm your password",

                obscureText = true,
                keyboardType = KeyboardType.Password,

                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                }

                )



            Spacer(modifier = Modifier.height(60.dp))


            CustomFilledButton(text = "Done",
                onClick = {
                    navController?.navigate(CreatePinCode.route)
                })






        }
    }
}

@Preview
@Composable
fun DefaultResetPassword() {
    ResetPasswordView()
}