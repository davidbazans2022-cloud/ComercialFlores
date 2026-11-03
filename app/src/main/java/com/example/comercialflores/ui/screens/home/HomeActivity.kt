package com.example.comercialflores.ui.screens.home

import android.R.attr.text
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.comercialflores.ui.screens.menu.Menu
import com.example.comercialflores.ui.components.BottomNavBar
import com.example.comercialflores.ui.theme.ComercialFloresTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComercialFloresTheme {
                Scaffold(
                    bottomBar = { BottomNavBar(selectedIndex = 0) }
                ) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        onVerCatalogoClick = {
                            startActivity(Intent(this, Menu::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onVerCatalogoClick: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        //  ENCABEZADO (Icono menú, Título tienda y Carrito)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*mas adelante pondre una accion aca*/}) {
                Icon(Icons.Outlined.Menu, contentDescription = "Menú")
            }
            Text(
                text = "COMERCIAL FLORES",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )

                Icon(Icons.Outlined.ShoppingBag, contentDescription = "Carrito")

        }

        Spacer(modifier = Modifier.height(16.dp))

        // SALUDO
        Text(
            text = "Hola, bienvenido de nuevo.",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold)

        Text(
            text = "¿Qué detalles buscas hoy para tu hogar?",
            style = MaterialTheme.typography.bodyMedium)


        Spacer(modifier = Modifier.height(20.dp))

        //Imagen desde Internet con Coil
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // Imagen desde internet
                AsyncImage(
                    model = "https://images.unsplash.com/photo-1585320806297-9794b3e4eeae?q=80&w=1000&auto=format&fit=crop",
                    contentDescription = "Destacado",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Degradado oscuro sutil para que el texto resalte
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f)),
                                startY = 100f
                            )
                        )
                )

                // Contenido de la tarjeta
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(20.dp)
                ) {
                    Text(
                        text = "COLECCIÓN ESPECIAL",
                        color = Color.White.copy(alpha = 0.8f),
                        style = MaterialTheme.typography.labelSmall,
                        letterSpacing = 1.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Arreglos Premium",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))



                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // coleecion
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "EXPLORA NUESTRA COLECCIÓN",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
            TextButton(onClick = onVerCatalogoClick) {
                Text(text = "Ver todo", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Lista horizontal de categorías con imágenes de internet
        val categorias = listOf(
            Pair("Habitacion", "https://estilospe.vtexassets.com/arquivos/ids/4111202/002032461-1.webp?v=639217120204400000"),
            Pair("Hogar", "https://images.unsplash.com/photo-1513519245088-0e12902e5a38?q=80&w=400&auto=format&fit=crop"),
            Pair("Accesorios", "https://images.unsplash.com/photo-1618221195710-dd6b41faaea6?q=80&w=400&auto=format&fit=crop")
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categorias) { categoria ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { /*cuando separe las categorias pondre aca*/ }
                ) {
                    Box(
                        modifier = Modifier
                            .size(76.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {
                        AsyncImage(
                            model = categoria.second,
                            contentDescription = categoria.first,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = categoria.first,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium

                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        //tarjeta infgerior
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /*aca tambien pondre otra accion mas adelante*/ },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEBE3D8))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "VIVE CON ESTILO, DECORA TU HOGAR.",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Contacta con nuestros asesores para poder ayudarte.",
                        style = MaterialTheme.typography.bodySmall

                    )
                }
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null

                )
            }
        }
    }
}