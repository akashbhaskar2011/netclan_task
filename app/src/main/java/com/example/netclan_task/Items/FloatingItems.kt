package com.example.netclan_task.Items


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp





@Composable
fun FloatingItems() {
    var isMenuExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {
                isMenuExpanded = !isMenuExpanded
            }
        ) {
            Icon(
                imageVector = if (isMenuExpanded) Icons.Default.Close else Icons.Default.Add,
                contentDescription = "Add"
            )
        }

        // Animate the visibility and content size of the menu items
        AnimatedVisibility(
            visible = isMenuExpanded,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it }),
            modifier = Modifier
                .background(color = Color.White.copy(alpha = 0.5f))
                .padding(16.dp)
                .heightIn(min = 0.dp)
                .fillMaxWidth()
                .animateContentSize()
        ) {
            // When menu is expanded, display the menu items aligned to the right
            Column(
                modifier = Modifier.fillMaxWidth().height(370.dp),
                horizontalAlignment = Alignment.End
            ) {
                FloatingListItems()
            }
        }
    }
}


@Composable
fun FloatingItem(label: String, icon: ImageVector,) {
  Column( ){
      Row(
          modifier = Modifier.clickable {  }
//              .fillMaxWidth()
//        verticalAlignment = Alignment.CenterVertically
      ) {

          Text(text = label)
          Spacer(modifier = Modifier.width(10.dp))
          Icon(
              imageVector = icon,
              contentDescription = null,
              tint = Color.Black,
              modifier = Modifier.size(24.dp)
          )


      }
      Spacer(modifier = Modifier.height(20.dp))

  }
}


@Composable
fun FloatingListItems() {
    val items = listOf(
        ListItem("Item 1", Icons.Default.Home),
        ListItem("Item 2", Icons.Default.Favorite),
        ListItem("Item 3", Icons.Default.Add),
        ListItem("Item 4", Icons.Default.Close),
        ListItem("Item 5", Icons.Default.Add),
        ListItem("Item 1", Icons.Default.Home),
        ListItem("Item 2", Icons.Default.Favorite),
        ListItem("Item 3", Icons.Default.Add),

    )

        items.forEach{item->
            FloatingItem(label = item.name,item.icon)



    }
}