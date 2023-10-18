package com.example.netclan_task.Model

import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
) {
}