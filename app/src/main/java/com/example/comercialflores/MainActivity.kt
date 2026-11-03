package com.example.comercialflores

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


import androidx.compose.ui.unit.dp
import com.example.comercialflores.ui.screens.home.HomeActivity
import com.example.comercialflores.ui.screens.terminos.TerminosActivity
import com.example.comercialflores.ui.theme.ComercialFloresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComercialFloresTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaPrincipal(
                        modifier = Modifier.padding(innerPadding),
                        onEmpezarClick = {
                            val intent = Intent(this@MainActivity, HomeActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun PantallaPrincipal(modifier: Modifier,
                      onEmpezarClick: () -> Unit) {

    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(100.dp))


        Text(stringResource(R.string.nombre_tienda),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(50.dp))

        Image( modifier = Modifier
            .size(160.dp)
            .clip(RoundedCornerShape(20.dp)),
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Logo de la empresa")

        Spacer(modifier = Modifier.height(32.dp))



        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onEmpezarClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("Empezar")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
        }





        Spacer(modifier = Modifier.height(24.dp))



    }
}

