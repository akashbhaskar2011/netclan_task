package com.example.netclan_task.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.netclan_task.Screens.MyTab
import com.example.netclan_task.Navigations.Routes

@Composable
fun Merchant(){
    LazyColumn {
        items(10) { index ->
           MerchantItems()
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

}


@Composable
fun MerchantItems(){
    Box{
        ElevatedCard(
            colors = CardDefaults.cardColors(
                containerColor =Color.White,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp,
            ),
            modifier = Modifier
                .padding(start = 30.dp)
                .width(310.dp)
                .height(240.dp)
                .clickable { }
        ) {
            Column (modifier = Modifier.padding(top=10.dp, start = 10.dp)){
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "+INVITE",
                        modifier = Modifier
                            .padding(start=210.dp,end=10.dp),

                    )
                }
                Column (modifier=Modifier.padding(start=90.dp)){
                    Text(text = "userNamr")
                    Text(text = "Location|workfield")
                    Text(text = "distance 200km")
                    LinearProgressIndicator(
                        progress = 0.7f, modifier = Modifier
                            .height(5.dp)
                            .width(80.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Coffee |Business|fiendship")
                Text(text = "bio goes here of the\nuser :)")


            }

        }
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .padding(start = 10.dp, top = 25.dp)
                .width(100.dp)
                .height(100.dp)
        ) {
            Text(
                text = "Elevated",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
        }
    }


}



@Preview
@Composable
fun Merpre(){
   BusinessItems()
}