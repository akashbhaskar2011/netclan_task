package com.example.netclan_task.Items

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.N)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun ChipDisp( fruits:List<String>) {
    val fruitsList:List<String> = fruits
    var isSelected by remember {
        mutableStateOf(false)
    }
    var selectedItems = remember { mutableStateListOf<String>() }
    Row(){
        fruitsList.forEach(){item->

                    isSelected=selectedItems.contains(item)
                    FilterChip(modifier = Modifier.padding(10.dp)
                           .clip(shape = RoundedCornerShape(20.dp)) , selected = isSelected, onClick = {
                        when(selectedItems.contains(item)){
                            true->selectedItems.remove(item)
                            false->selectedItems.add(item)
                        }
                    },
                        label = { Text(text = item)})
                }

        }
        }
//    }
//}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ChipGrid() {
    val listOfLists = listOf(
        listOf("apple", "banana", "cherry"),
        listOf("date", "fig", "grape"),
        listOf("kiwi", "lemon")
    )

    Column() {
        listOfLists.forEach { fruitsList ->
            ChipDisp(fruitsList)
        }
    }
}


