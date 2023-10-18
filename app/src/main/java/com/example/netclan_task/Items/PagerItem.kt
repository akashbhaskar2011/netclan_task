package com.example.netclan_task.Items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun HorizontalPagerTabRowSample() {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        5
    }
    val pages = (1..5).map { "Page $it" }
    val scrollCoroutineScope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                )
            },
        ) {
            pages.forEachIndexed { index, title ->
                Text(text = title,
                    modifier = Modifier
                        .clickable {
                            scrollCoroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                        .padding(8.dp))
            }
        }

//        HorizontalPager(
//            pageCount = 5,
//            state = pagerState,
//            pageSpacing = 8.dp
//        ) { page ->
//            Text(
//                text = pages[page],
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .background(Color.LightGray)
//                    .fillMaxWidth()
//                    .padding(32.dp)
//            )
        }
    }
//}

//https://medium.com/@domen.lanisnik/exploring-the-official-pager-in-compose-8c2698c49a98


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun vie1(){
    HorizontalPagerTabRowSample()
}