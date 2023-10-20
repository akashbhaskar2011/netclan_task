package com.example.netclan_task.Items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState



@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyTab() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val tabItems = listOf("home", "2ndpage", "3rd page")
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


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyTab2() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val tabItems = listOf("home", "2ndpage", "3rd page", "p4", "p5")
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










@OptIn(ExperimentalPagerApi::class)
@Composable
fun HandleSwipe(){

        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }

        val tabItems = listOf(MyTab(), MyTab2())
        val pagerState = rememberPagerState(pageCount = 2)

        LaunchedEffect(selectedTabIndex) {
            pagerState.animateScrollToPage(selectedTabIndex)
        }

        LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
            if (!pagerState.isScrollInProgress) {
                selectedTabIndex = pagerState.currentPage
            }
        }



            HorizontalPager(state = pagerState) { index ->
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "1"+index)
                }
            }
        }



@Preview
@Composable
fun pre1() {
    MyTab()
}


