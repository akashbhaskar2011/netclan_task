package com.example.netclan_task.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.netclan_task.Items.ScrollableItemList
import com.example.netclan_task.Items.ScrollableItemListPreview
import com.example.netclan_task.Navigations.Routes
import com.example.netclan_task.R


@Composable
fun NavDrawerItem(navController: NavController) {
    Column(
        modifier = Modifier.width(300.dp)
    ) {
        Box(
            modifier = Modifier.weight(.25f)
        ) {
            Image(
                modifier = Modifier
                    .width(300.dp)
                   ,
                painter = painterResource(id = R.drawable.backgrounimage),
                contentDescription = "profile image"
            )

            Box( ) {
                Column(
                    Modifier
                        .padding(start = 20.dp, top = 25.dp, bottom = 25.dp)
                        .fillMaxWidth(),

                    ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "profile image",
                            modifier = Modifier
                                .clip(RoundedCornerShape(40.dp))
                                .size(75.dp)
                                .clickable {
                                    navController.navigate(Routes.Profile.routes)
                                },

                            )
                        Spacer(modifier = Modifier.padding(start = 140.dp, end = 10.dp))
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Settings,
                                contentDescription = "Localized description",
                                Modifier.clickable {
                                    navController.navigate(Routes.Settings.routes)
                                },
                            )
                        }
                    }
                    Text(text = "name here",  style = TextStyle(color = Color.White, fontSize = 20.sp), modifier = Modifier
                        .clickable {

                        }
                    )
                    Text(text = "available",  style = TextStyle(color = Color.White, fontSize = 20.sp), modifier = Modifier
                        .clickable {

                        })


                    LinearProgressIndicator(
                        progress = 0.7f, modifier = Modifier
                            .height(5.dp)
                            .width(80.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Text(text = "random id",  style = TextStyle(color = Color.White, fontSize = 20.sp))
                    Spacer(modifier = Modifier.width(25.dp))
                    ScrollableItemListPreview()
                }


            }


        }

}}


