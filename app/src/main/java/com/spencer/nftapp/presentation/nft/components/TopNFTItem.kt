package com.spencer.nftapp.presentation.nft.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spencer.nftapp.R
import com.spencer.nftapp.presentation.ui.theme.Normal

@Composable
fun TopNFTItem(asset:Int,title:String,
               user:String,
                price:String,
               percent:String,
               dump:Boolean = false
               ) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 10.dp)) {
        Row() {
            Image(
                painter = painterResource(asset),
                contentDescription = "nft collection",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                     // add a border (optional)
            )

            Spacer(modifier = Modifier.width(15.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = title,
                fontSize = 16.sp,
                    fontWeight = FontWeight.W400
                    )

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = user,
                    fontSize = 12.sp,
                    color = Normal,
                    fontWeight = FontWeight.W400
                )

            }
            
        }
        
        Column(horizontalAlignment = Alignment.End) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.ethereum), contentDescription = "")
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = price,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W700
                )

            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = percent,
                color = if (!dump) Color(34, 197, 94) else Color(239, 68, 68,),
                fontSize = 12.sp,
                fontWeight = FontWeight.W400
            )

        }
    }
}


@Preview
@Composable
fun PrevTopNFTItem() {
    TopNFTItem(R.drawable.collection1, title = "Bored Ape Yacht Club",
    user = "@jailyn1509",
        price = "5,4563", percent = "+23,00%",)
}