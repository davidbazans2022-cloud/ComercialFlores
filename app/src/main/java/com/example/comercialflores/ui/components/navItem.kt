package com.example.comercialflores.ui.components

import android.content.Intent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.comercialflores.MainActivity
import com.example.comercialflores.ui.screens.menu.Menu
import com.example.comercialflores.ui.screens.sobrenosotros.SobreNosotrosActivity
import com.example.comercialflores.ui.screens.terminos.TerminosActivity
import kotlin.jvm.java

data class NavItem(val label: String, val icon: ImageVector, val destino: Class<*>)

@Composable
fun BottomNavBar(selectedIndex: Int) {
    val context = LocalContext.current

    val items = listOf(
        NavItem("Categorías", Icons.Default.Menu, Menu::class.java),
        NavItem("Nosotros", Icons.Default.Info, SobreNosotrosActivity::class.java),
        NavItem("Términos", Icons.Default.Description, TerminosActivity::class.java)
    )

    Surface(
        modifier = Modifier
            .navigationBarsPadding()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        shape = RoundedCornerShape(28.dp),
        color = Color.Black.copy(alpha = 0.85f),
        tonalElevation = 8.dp
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            windowInsets = WindowInsets(0.dp)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == selectedIndex,
                    onClick = {
                        if (index != selectedIndex) {
                            context.startActivity(Intent(context, item.destino))
                        }
                    },
                    icon = { Icon(item.icon, contentDescription = item.label) },
                    label = { Text(item.label) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        indicatorColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                        unselectedTextColor = Color.White.copy(alpha = 0.6f)
                    )
                )
            }
        }
    }
}