package com.feria.israelferia

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class ArtistasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.artistas),
                        contentDescription = "Artistas",
                        modifier = Modifier.fillMaxWidth().height(250.dp)
                    )
                    Text(
                        text = "Estos son los artistas invitados a la feria...",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Button(onClick = {
                        startActivity(Intent(this@ArtistasActivity, MainActivity::class.java))
                    }) {
                        Text("Regresar al inicio")
                    }
                }
            }
        }
    }
}