package com.example.netclan_task.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.netclan_task.Items.MyTab
import com.example.netclan_task.Navigations.Routes

@Composable
fun Explore(){
    Column{
        MyTab()
        Text(text = "safjhsdvfhsdfghdsghs")
    }
}


@Preview
@Composable
fun Tabpre(){
    Explore()
}