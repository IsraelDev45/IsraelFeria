package com.feria.israelferia

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NaveScreen(nombre: String, imagen: Int) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = nombre, style = MaterialTheme.typography.headlineMedium)
            Image(
                painter = painterResource(id = imagen),
                contentDescription = nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Suspendisse ultrices nulla nec erat porttitor, id elementum lorem iaculis.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}