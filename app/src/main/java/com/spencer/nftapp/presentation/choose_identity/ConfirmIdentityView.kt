package com.spencer.nftapp.presentation.choose_identity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.spencer.nftapp.R
import com.spencer.nftapp.presentation.components.CustomFilledButton
import com.spencer.nftapp.presentation.ui.theme.Blue
import com.spencer.nftapp.presentation.ui.theme.Normal
import com.spencer.nftapp.presentation.choose_identity.components.FieldSelection
import com.spencer.nftapp.presentation.main.VerifyIdentity

@Composable
fun ConfirmIdentityView(
    navController: NavController) {
    val currentIndexSelected = remember {
        mutableStateOf(0)
    }


    Scaffold() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(horizontal = 10.dp)

            ) {
            Spacer(modifier = Modifier.height(40.dp))

            Image(painter = painterResource(id = R.drawable.verification),

                contentDescription = stringResource(R.string.verify_identity,
                ), modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(300.dp)
                    .height(130.dp),
            contentScale = ContentScale.Crop,)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(R.string.verify_identity), fontSize = 18.sp,
            fontWeight = FontWeight.W700)
            Spacer(modifier = Modifier.height(20.dp))

            Text(text = stringResource(R.string.help_protect), fontSize = 14.sp,

                fontWeight = FontWeight.W400, textAlign = TextAlign.Center,
            color = Normal)

            Spacer(modifier = Modifier.height(30.dp))
            
            FieldSelection(title = "Email",
                subtitle = "Verify with email",
                imageVector = Icons.Default.Email, isSelected = currentIndexSelected.value == 0) {
                currentIndexSelected.value = 0
            }

            Spacer(modifier = Modifier.height(20.dp))

            FieldSelection(title = "Phone Number",
                subtitle = "Get Started",
                imageVector = Icons.Default.Phone, isSelected = currentIndexSelected.value == 1) {
                currentIndexSelected.value = 1
            }



            Spacer(modifier = Modifier.height(50.dp))

            CustomFilledButton(text = "Countie",
                color = Blue,
                onClick = {
                    navController.navigate(VerifyIdentity.route)
                })






        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewConfirmIdentity() {
    //ConfirmIdentityView()
}