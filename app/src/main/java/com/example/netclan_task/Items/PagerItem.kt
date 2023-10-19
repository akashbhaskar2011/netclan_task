import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.netclan_task.Navigations.Routes
import com.example.netclan_task.Screens.ThreeBounceAnimation
import kotlinx.coroutines.delay

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun PagerWithTabs() {
    var selectedTab by remember { mutableStateOf(0) }

    val pagerState = rememberPagerState(pageCount = {
        4
    })

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top App Bar with Tabs
        TopAppBar(
            title = {
                Text(text = "Pager with Tabs")
            },
//            backgroundColor = Color.Blue,
        )

        // Tabs
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth(),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab])
                )
            }
        ) {
//            Tab(
//                text ={ text = "Tab 1") },
//                onClick = { selectedTab = 0 }
//            )
//            Tab(
//                text = { Text(text = "Tab 2") },
//                onClick = { selectedTab = 1 }
//            )
//            Tab(
//                text = { Text(text = "Tab 3") },
//                onClick = { selectedTab = 2 }
//            )
        }

        // Pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) { page ->
            when (page) {
                0 -> {
                    // Content for Tab 1
                    Text(text = "Tab 1 Content")
                }
                1 -> {
                    // Content for Tab 2
                    Text(text = "Tab 2 Content")
                }
                2 -> {
                    // Content for Tab 3
                    Text(text = "Tab 3 Content")
                }
            }
        }

        ThreeBounceAnimation()

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "NetClan")
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Splash1(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PagerWithTabs()
    }

    LaunchedEffect(true) {
        delay(1000)
        navController.navigate(Routes.BottomNav.routes)
    }
}
