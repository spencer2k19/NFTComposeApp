package com.spencer.nftapp.presentation.choose_identity.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spencer.nftapp.presentation.ui.theme.Blue

@Composable
fun FieldSelection(title:String,
                   subtitle:String,
                   imageVector: ImageVector,
                   isSelected:Boolean,
                   onClick:()->Unit) {

    val indication = rememberRipple(color = Color.Gray)

     Box(modifier = Modifier
    .fillMaxWidth()
    .border(
        width = 1.dp,
        color = if (!isSelected) Color(217, 217, 217) else Blue,
    )
    .background(if (isSelected) Color(0xFFDBEAFE) else Color.White)
    .clip(RoundedCornerShape(3.dp))
         .clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = indication,
    ) {
        onClick()
    }


) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 20.dp)) {
        Box(modifier = Modifier
            .width(44.dp)
            .height(44.dp)
            .background(color = if (isSelected) Blue else Color(243, 244, 246))) {
            Icon(imageVector = imageVector, contentDescription ="", modifier = Modifier.align(Alignment.Center),

               tint = if (isSelected) Color.White else Color.Black )
        }

        Spacer(modifier = Modifier.width(20.dp))
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.W700,)
            Text(text = subtitle, fontSize = 12.sp, fontWeight = FontWeight.W400,)
        }

        
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterVertically),
            horizontalArrangement = Arrangement.End,
            ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = if (isSelected) Blue else Color(191, 191, 191),
                        shape = CircleShape
                    )
                    .background(color = if (isSelected) Blue else Color.White)

            ) {
                if (isSelected) {
                    Icon(imageVector = Icons.Default.Check,

                        contentDescription = "",
                    tint = Color.White, modifier = Modifier.clip(CircleShape))
                }
            }
        }






    }
}
}

@Preview(showBackground = true)
@Composable
fun DefaultFieldSelection() {
    FieldSelection(title = "Phone Number",
        subtitle = "Get Started",
        imageVector = Icons.Default.Phone, isSelected = false) {

    }
}


