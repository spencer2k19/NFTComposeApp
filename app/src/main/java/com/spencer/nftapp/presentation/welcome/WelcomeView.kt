package com.spencer.nftapp.presentation.welcome

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.spencer.nftapp.R
import com.spencer.nftapp.presentation.components.CustomFilledButton
import com.spencer.nftapp.presentation.main.Login
import com.spencer.nftapp.presentation.ui.theme.Blue
import com.spencer.nftapp.presentation.ui.theme.Gray
import com.spencer.nftapp.presentation.ui.theme.LegerBlue
import kotlinx.coroutines.launch

@Composable
fun dotComponent(isActive:Boolean
) {
    Spacer(
        modifier = Modifier
            .width(48.dp)
            .height(4.dp)
            .background(
                color = if (isActive) Blue else LegerBlue
            )
    )
}


@ExperimentalPagerApi
@Composable
fun WelcomeView(
    navController: NavController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    val state = rememberPagerState()
    val scope = rememberCoroutineScope()
    val image = remember{
        mutableStateOf(R.drawable.intro1)
    }
    Column(modifier = Modifier
        .padding(horizontal = 15.dp,
            vertical = 15.dp,),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextButton(onClick = {
                navController.navigate(Login.route)
            }) {
                Text(text = "Skip",
                    color = Color.Black,
                    fontSize = 12.sp
                )
            }

            Row {
                dotComponent(isActive = true)
                Spacer(modifier = Modifier.width(5.dp))
                dotComponent(isActive = state.currentPage>=1)
                Spacer(modifier = Modifier.width(5.dp))
                dotComponent(isActive = state.currentPage >= 2)

            }
        }

        Column(
            modifier = Modifier.fillMaxHeight() ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            HorizontalPager(count = welcomeViewModel.slidesImage.size,

                state = state, modifier = Modifier.fillMaxWidth()) { page->
                Log.e("page","CURRENT PAGE: $page")
                //image.value = welcomeViewModel.slidesImage[page]

                Image(painter = painterResource(welcomeViewModel.slidesImage[state.currentPage]) ,
                    contentDescription = "Intro 1", modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                )

            }



            Spacer(modifier = Modifier.height(80.dp))
            Text(text = welcomeViewModel.titles[state.currentPage],
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(text = welcomeViewModel.descriptions[state.currentPage],
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Gray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(50.dp))

            CustomFilledButton(text = if (state.currentPage == 2)"Get Started" else "Next",
                onClick = {
                    scope.launch {
                        if (state.currentPage < 2) {
                            state.scrollToPage(state.currentPage+1)
                        } else {
                            navController.navigate(Login.route)
                        }

                    }

                })


        }



    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreviewWelcome() {
   // WelcomeView()
}