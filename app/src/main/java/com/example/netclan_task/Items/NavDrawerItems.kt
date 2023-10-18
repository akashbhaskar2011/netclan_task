package com.example.netclan_task.Items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun NavDrawerItem() {
    Box(modifier = Modifier
        .width(200.dp)
        .height(200.dp))
LazyColumn(modifier = Modifier.padding(5.dp)){
    item {Text(text = "items")
    Spacer(modifier = Modifier.height(20.dp))}

    item {Text(text = "items")
        Spacer(modifier = Modifier.height(20.dp))}
    item {Text(text = "items")
        Spacer(modifier = Modifier.height(20.dp))}
    item {Text(text = "items")
        Spacer(modifier = Modifier.height(20.dp))}
    item {Text(text = "items")
        Spacer(modifier = Modifier.height(20.dp))}
    item {Text(text = "items")
        Spacer(modifier = Modifier.height(20.dp))}
    item {Text(text = "items")
        Spacer(modifier = Modifier.height(20.dp))}
    item {Text(text = "items")
        Spacer(modifier = Modifier.height(20.dp))}
    item {Text(text = "items")
        Spacer(modifier = Modifier.height(20.dp))}




        item {Text(text = "items")
            Spacer(modifier = Modifier.height(20.dp))}
        item {Text(text = "items")
            Spacer(modifier = Modifier.height(20.dp))}
        item {Text(text = "items")
            Spacer(modifier = Modifier.height(20.dp))}
        item {Text(text = "items2")
            Spacer(modifier = Modifier.height(20.dp))}
        item {Text(text = "items")
            Spacer(modifier = Modifier.height(20.dp))}
        item {Text(text = "items")
            Spacer(modifier = Modifier.height(20.dp))}


}

}