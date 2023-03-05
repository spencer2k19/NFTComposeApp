package com.spencer.nftapp.presentation.nft.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spencer.nftapp.R
import com.spencer.nftapp.presentation.components.CustomFilledButton
import com.spencer.nftapp.presentation.ui.theme.Blue
import com.spencer.nftapp.presentation.ui.theme.Normal

@Composable
fun PopularNFTItem(asset:Int) {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.width(240.dp).padding(8.dp)

    ) {
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            ) {
                Image(
                    painter = painterResource(id = asset),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(
                            RoundedCornerShape(6.dp)
                        )
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)

                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(255, 255, 255, 89),
                                    Color(255, 255, 255, 20),

                                    )
                            )
                        )
                        .padding(8.dp)

                ) {
                    Text(
                        text = "04h 09m 12s",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,

                    )
                }
            }
            
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Rebels-NightCard#",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.W700
            )

            Spacer(modifier = Modifier.height(10.dp))
            
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
                ) {
                Column() {
                    Text(
                        text = "Current bid",
                        color = Normal,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W400
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Row() {
                        Image(painter = painterResource(id = R.drawable.ethereum), contentDescription = "")
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "10.01",
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500
                        )

                    }
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
                    modifier = Modifier.clip(RoundedCornerShape(3.dp))

                ) {
                    Text(text = "Place bid", color = Color.White)
                }
            }


        }



    }

}

@Preview
@Composable
fun PreviewPopularItem() {
    PopularNFTItem(asset = R.drawable.popular1)
}