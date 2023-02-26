package com.spencer.nftapp.presentation.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.spencer.nftapp.presentation.components.CustomFilledButton
import com.spencer.nftapp.presentation.components.CustomOutlinedTextField
import com.spencer.nftapp.presentation.main.Register
import com.spencer.nftapp.presentation.main.ResetPassword
import com.spencer.nftapp.presentation.ui.theme.Blue
import com.spencer.nftapp.presentation.ui.theme.Gray

@Composable
fun LoginView(
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
                   text = "Sign In",
                   color = Color.Black,
                   fontSize = 32.sp,
                   fontWeight = FontWeight.W700
               )
           })

       }
   ) {
       var text by remember { mutableStateOf("") }
       var textPassword by remember { mutableStateOf("") }
       Column(
           horizontalAlignment = Alignment.Start,
           modifier = Modifier

               .padding(
                   vertical = 20.dp,
                   horizontal = 20.dp
               )

       ) {

           Spacer(modifier = Modifier.height(60.dp))
           Text(
               text = "Email address", color = Gray,
               fontSize = 14.sp
           )


           Spacer(modifier = Modifier.height(10.dp))

           CustomOutlinedTextField(
               text = text,
               onValueChange = {
                   text = it
               },
               placeHolder = "Your User email address",
               leadingIcon = {
                   Icon(
                       imageVector = Icons.Default.Email,
                       contentDescription = "Email"
                   )
               },
           )

           Spacer(modifier = Modifier.height(40.dp))
           Text(
               text = "Password", color = Gray,
               fontSize = 14.sp
           )


           Spacer(modifier = Modifier.height(10.dp))

           CustomOutlinedTextField(
               text = textPassword,
               onValueChange = {
                   textPassword = it
               },
               placeHolder = "Your password",
               leadingIcon = {
                   Icon(
                       imageVector = Icons.Default.Lock,
                       contentDescription = "Password"
                   )
               },
               obscureText = true
           )


           Spacer(modifier = Modifier.height(2.dp))

           Row(
               horizontalArrangement = Arrangement.End,
               modifier = Modifier.fillMaxWidth()

           ) {
               TextButton(onClick = {
                   navController.navigate(ResetPassword.route)
               }) {
                   Text(
                       text = "Forgot Password?",
                       color = Blue,
                       fontSize = 12.sp

                   )
               }
           }

           Spacer(modifier = Modifier.height(30.dp))


           CustomFilledButton(text = "Sign In",
               onClick = { })


           Spacer(modifier = Modifier.height(15.dp))

           Row(
               horizontalArrangement = Arrangement.Center,
               modifier = Modifier.fillMaxWidth()

           ) {
               Text(
                   text = "Or sign in with",
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


           Row(
               verticalAlignment = Alignment.Bottom,

               modifier = Modifier
                   .fillMaxWidth()
                   .fillMaxHeight(),

               horizontalArrangement = Arrangement.Center

           ) {

               Text(text = "Don't have an account ?", color = Color.Black)
               Spacer(modifier = Modifier.width(5.dp))
               Text(text = "Sign up",
                   color = Blue,
                   modifier = Modifier.clickable {
                       navController.navigate(Register.route)

                   }

               )

           }


       }
   }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewLogin() {
   // LoginView()
}