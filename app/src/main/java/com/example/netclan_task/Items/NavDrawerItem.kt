package com.example.netclan_task.Items
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ListItem(val name: String, val icon: ImageVector)

@Composable
fun ScrollableItemList(items: List<ListItem>) {
    LazyColumn {
        items(items) { item ->
            ClickableListItem(item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ClickableListItem(item: ListItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Do nothing when clicked */ }
            .padding(top = 16.dp, end = 20.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Icon(imageVector = item.icon, contentDescription = null)

            Text(text = item.name, style = TextStyle(fontSize = 20.sp, color = Color.White))
        }
    }
}

@Composable
fun ScrollableItemListPreview() {
    val items = listOf(
        ListItem("Item 1", Icons.Default.Home),
        ListItem("Item 2", Icons.Default.Favorite),
        ListItem("Item 3", Icons.Default.Add),
        ListItem("Item 4", Icons.Default.Close),
        ListItem("Item 5", Icons.Default.Add),
        ListItem("Item 1", Icons.Default.Home),
        ListItem("Item 2", Icons.Default.Favorite),
        ListItem("Item 3", Icons.Default.Add),
        ListItem("Item 4", Icons.Default.Close),
        ListItem("Item 5", Icons.Default.Add)
    )

    ScrollableItemList(items)
}
