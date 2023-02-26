package com.spencer.nftapp.presentation.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.spencer.nftapp.R
import com.spencer.nftapp.presentation.components.CustomFilledButton
import com.spencer.nftapp.presentation.components.CustomOutlinedTextField
import com.spencer.nftapp.presentation.main.ConfirmIdentity
import com.spencer.nftapp.presentation.ui.theme.Blue
import com.spencer.nftapp.presentation.ui.theme.Gray

@Composable
fun RegisterView(
    navController: NavController
) {
   Scaffold(
       topBar = {

           TopAppBar(

               backgroundColor = Color.White,
               elevation = 0.dp,
               modifier = Modifier.padding(vertical = 10.dp),
               title = {
                   Text(
                       text = "Create an Account",
                       color = Color.Black,
                       fontSize = 32.sp,
                       fontWeight = FontWeight.W700
                   )
               }, navigationIcon = {
                   IconButton(onClick = {
                       navController.navigateUp()
                   }) {
                       Icon(imageVector = Icons.Default.ArrowBack,
                           contentDescription = "back space")
                   }
               })

       }


   ) {
       var textUsername by remember { mutableStateOf("") }
       var textEmail by remember { mutableStateOf("") }
       var textPassword by remember {
           mutableStateOf("")
       }

       Column(
           horizontalAlignment = Alignment.Start,
           modifier = Modifier

               .padding(
                   vertical = 20.dp,
                   horizontal = 20.dp
               )

       ) {

           Text(
               text = "Username", color = Gray,
               fontSize = 14.sp
           )


           Spacer(modifier = Modifier.height(10.dp))

           CustomOutlinedTextField(
               text = textUsername,
               onValueChange = {
                   textUsername = it
               },
               placeHolder = "Your Username",
               leadingIcon = {
                   Icon(
                       imageVector = Icons.Outlined.PersonOutline,
                       contentDescription = "username"
                   )
               },
           )

           Spacer(modifier = Modifier.height(30.dp))
           Text(
               text = "Email address", color = Gray,
               fontSize = 14.sp
           )


           Spacer(modifier = Modifier.height(10.dp))

           CustomOutlinedTextField(
               text = textEmail,
               onValueChange = {
                   textEmail = it
               },
               placeHolder = "Your user email address",
               leadingIcon = {
                   Icon(
                       imageVector = Icons.Outlined.Email,
                       contentDescription = "email"
                   )
               },
               keyboardType = KeyboardType.Email
           )


           Spacer(modifier = Modifier.height(30.dp))

           Text(
               text = stringResource(R.string.password), color = Gray,
               fontSize = 14.sp
           )
           Spacer(modifier = Modifier.height(10.dp))


           CustomOutlinedTextField(
               text = textPassword,
               onValueChange = {
                   textPassword = it
               },
               placeHolder = stringResource(R.string.password),
               leadingIcon = {
                   Icon(
                       imageVector = Icons.Outlined.Lock,
                       contentDescription = stringResource(id = R.string.password)
                   )
               },
               keyboardType = KeyboardType.Password,
               obscureText = true
           )


           Spacer(modifier = Modifier.height(2.dp))




           Spacer(modifier = Modifier.height(30.dp))


           CustomFilledButton(text = "Sign Up",
               onClick = {
                   navController.navigate(ConfirmIdentity.route)
               })


           Spacer(modifier = Modifier.height(15.dp))

           Row(
               horizontalArrangement = Arrangement.Center,
               modifier = Modifier.fillMaxWidth()

           ) {
               Text(
                   text = "Or sign up with",
                   textAlign = TextAlign.Center,
                   color = Color(0xFF8C8C8C)
               )
           }

           Spacer(modifier = Modifier.height(15.dp))
           OutlinedButton(
               onClick = { },
               modifier = Modifier
                   .height(50.dp)
                   .fillMaxWidth(),
               border = BorderStroke(1.dp, Color(0xFFDBDBDB)),
               shape = RoundedCornerShape(3.dp)

           ) {
               Icon(
                   imageVector = Icons.Default.Link,
                   contentDescription = "",
                   tint = Color.Black

               )

               Spacer(modifier = Modifier.width(5.dp))
               Text("Connect Wallet", color = Color.Black)

           }

           Spacer(modifier = Modifier.height(5.dp))

           Row(
               verticalAlignment = Alignment.Bottom,

               modifier = Modifier
                   .fillMaxWidth()
                   .fillMaxHeight(),

               horizontalArrangement = Arrangement.Center

           ) {

               Text(text = "Already have an account ?", color = Color.Black)
               Spacer(modifier = Modifier.width(5.dp))
               Text(text = "Sign in",
                   color = Blue,
                   modifier = Modifier.clickable {
                       navController.navigateUp()
                   }

               )

           }


       }
   }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewRegister() {
   // RegisterView()
}