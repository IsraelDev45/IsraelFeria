package com.feria.israelferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class Nave3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaveScreen("Nave 3", R.drawable.nave3)
        }
    }
}