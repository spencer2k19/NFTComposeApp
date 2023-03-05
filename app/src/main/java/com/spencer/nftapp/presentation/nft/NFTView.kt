package com.spencer.nftapp.presentation.nft

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spencer.nftapp.R
import com.spencer.nftapp.presentation.nft.components.PopularNFTItem
import com.spencer.nftapp.presentation.nft.components.TextOption
import com.spencer.nftapp.presentation.nft.components.TopNFTItem
import com.spencer.nftapp.presentation.ui.theme.Blue
import com.spencer.nftapp.presentation.ui.theme.Normal




@Composable
fun NFTView(
    modifier: Modifier = Modifier,
    viewModel:NFTViewModel = hiltViewModel()
) {
    Column(modifier = modifier
        .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 70.dp)) {
       Row(modifier = Modifier.fillMaxWidth(),
       verticalAlignment = Alignment.Top

           ) {
         TextOption(title = "Popular",
             isSelected = viewModel.currentOptionIndex.value == 0) {
            viewModel.setCurrentOption(0)
         }
           Spacer(modifier = Modifier.width(10.dp))
           TextOption(title = "Market",isSelected = viewModel.currentOptionIndex.value == 1) {
               viewModel.setCurrentOption(1)
           }
           Spacer(modifier = Modifier.width(10.dp))

           TextOption(title = "Primanry/IGO",isSelected = viewModel.currentOptionIndex.value == 2) {
               viewModel.setCurrentOption(2)
           }
           Spacer(modifier = Modifier.weight(1f))

           IconButton(onClick = {  }) {
               Icon(imageVector = ImageVector.vectorResource(id = R.drawable.search),
                   contentDescription = "", modifier = Modifier

               )
           }
       }

        Spacer(modifier = Modifier.height(15.dp))
       Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
           LazyRow{
               item {
                   PopularNFTItem(asset = R.drawable.popular1)
                   PopularNFTItem(asset = R.drawable.popular2)
               }
           }

           Spacer(modifier = Modifier.height(15.dp))
           Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
               Text(text = "Top Collections", color = Color.Black,
                   fontWeight = FontWeight.W700, fontSize = 16.sp)



               Text(text = "View all", color = Blue,
                   fontWeight = FontWeight.W500, fontSize = 15.sp, modifier = Modifier.clickable (
                       interactionSource = remember { MutableInteractionSource() },
                       indication = rememberRipple(color = Blue),
                   ){

                   })

           }

           Spacer(modifier = Modifier.height(15.dp))
           TopNFTItem(R.drawable.collection1, title = "Bored Ape Yacht Club",
               user = "@jailyn1509",
               price = "5,4563", percent = "+23,00%",)
           TopNFTItem(R.drawable.collection2, title = "Dejah Zulauf",
               user = "@Dejah09",
               price = "5,0157", percent = "-31,20%",dump = true)

           TopNFTItem(R.drawable.collection3, title = "Jailyn Crona",
               user = "@jailyn1509",
               price = "5,4563", percent = "+23,00%")
       }

    }
}

@Preview
@Composable
fun PreviewNFTView() {
    NFTView()
}