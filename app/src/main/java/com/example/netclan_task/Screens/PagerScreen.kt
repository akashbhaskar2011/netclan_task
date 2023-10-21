package com.example.netclan_task.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyTab() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val tabItems = listOf("Personal", "Business", "Merchant")
    val pagerState = rememberPagerState(pageCount = tabItems.size)

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    Column(modifier = Modifier.background(color = Color.White)) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index

                    },
                    text = { Text(text = item) }

                )
            }
        }

        HorizontalPager(state = pagerState) { index ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, bottom = 80.dp)) {
                when (index){
                    0-> Personal()
                    1-> Business()
                    2->Merchant()
                }
//                Spacer(modifier = Modifier.height(1000.dp))

            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyTab2() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val tabItems = listOf("Personal", "Business",)
    val pagerState = rememberPagerState(pageCount = tabItems.size)

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    Column {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index

                    },
                    text = { Text(text = item) }
                )
            }
        }

        HorizontalPager(state = pagerState) { index ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = tabItems[index])
            }
        }
    }
}




@Preview
@Composable
fun pre1() {
    MyTab()
}


