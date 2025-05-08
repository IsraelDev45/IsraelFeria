package com.feria.israelferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.content.Intent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FeriaTheme {
                MainScreen(onNavigateToSecondActivity = {
                    startActivity(Intent(this, Activity2::class.java))
                })
            }
        }
    }
}

@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BusinessItem("Nave 1", R.drawable.nave1) { context ->
                context.startActivity(Intent(context, Nave1Activity::class.java))
            }
            BusinessItem("Nave 2", R.drawable.nave2) { context ->
                context.startActivity(Intent(context, Nave2Activity::class.java))
            }
            BusinessItem("Nave 3", R.drawable.nave3) { context ->
                context.startActivity(Intent(context, Nave3Activity::class.java))
            }
            BusinessItem("Artistas y Concierto", R.drawable.artistas) { context ->
                context.startActivity(Intent(context, ArtistasActivity::class.java))
            }

            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes")
            }
        }
    }
}

@Composable
fun BusinessItem(nombre: String, imagen: Int, onClick: (android.content.Context) -> Unit) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = imagen),
                    contentDescription = "Imagen de $nombre",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(8.dp)
                )
                Text(
                    text = nombre,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Button(
                onClick = { onClick(context) },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("Info")
            }
        }
    }
}

@Composable
fun FeriaTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) {
        darkColorScheme(
            primary = Color(0xFFD0BCFF) // Purple80
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF6650a4) // Purple40
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(
            bodyLarge = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        ),
        content = content
    )
}