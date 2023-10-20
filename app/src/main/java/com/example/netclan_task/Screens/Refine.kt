@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.netclan_task.Screens

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.netclan_task.Items.ChipDisp
import com.example.netclan_task.Items.ChipGrid
import com.example.netclan_task.Navigations.Routes

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun RefineTopBar(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Refine")
                },

                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Routes.BottomNav.routes){
                            popUpTo("Refine") {
                                inclusive = true
                            }
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }

            )
        },
        content = {paddingValue->
            Column(modifier= Modifier.padding(paddingValue))
            {
                RefineContent(navController)
            }
        }
    )

}


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun RefineContent(navController: NavController) {

    var bio by remember {
        mutableStateOf("HI comunity")
    }


    Column ( modifier= Modifier
        .padding(top = 10.dp, start = 40.dp,end=20.dp, bottom = 5.dp)
        .fillMaxSize()){

        var sliderPosition by remember { mutableIntStateOf(10) }

        Text(text = "Select Your Avialablilty")
        AvialabilityDropdown()
        Text(text = "Add your Staus")

        TextField(value =bio , onValueChange ={newText->
            bio=newText}, modifier = Modifier.clip(shape = RoundedCornerShape(15.dp)) )

        Text(text = "Select hyper local distance")

        Text(
            text = sliderPosition.toString(),
            modifier = Modifier
                .offset(
                    y = (-20).dp,
                    x = ((sliderPosition) * 3).dp
                ) // Adjust the vertical offset as needed
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
        )
        Slider(
            value = sliderPosition.toFloat(),
            onValueChange = { sliderPosition = it.toInt() },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
//            steps = 1,
            valueRange = 0f..100f
        )
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "0",
                modifier = Modifier.align(Alignment.TopStart)
            )
            Text(
                text = "100",
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
       ChipGrid()
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        Button(onClick = { navController.navigate(Routes.BottomNav.routes){
            popUpTo("Refine")
        } }
           ) {
            Text(text="save and explore")

        }}


    }


}







@Composable
fun AvialabilityDropdown() {
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    // We want to react on tap/press on TextField to show menu
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            // The `menuAnchor` modifier must be passed to the text field for correctness.
            modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)).menuAnchor(),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}



//
//@Preview
//@Composable
//fun view1(){
//    val navController = rememberNavController()
//    RefineTopBar(navController)
//}