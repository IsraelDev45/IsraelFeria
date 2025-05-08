package com.feria.israelferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class Nave2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaveScreen("Nave 2", R.drawable.nave2)
        }
    }
}