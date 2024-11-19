package com.nicolaischirmer.examenej2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicolaischirmer.examenej2.ui.theme.ExamenEjercicio2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenEjercicio2Theme {
                Ejericio2()
            }
        }
    }
}

@Composable
fun Ejericio2() {
    var colorSeleccionado by remember { mutableStateOf(Color.White) }

    Column (
        modifier = Modifier.padding(top = 100.dp)
    ) {
        Row {
            Text("Selecciona un color:")
            ListaColores(onColorSeleccionado = { color -> colorSeleccionado = color })
        }
        Column {
            Text("Color seleccionado:")
            Spacer(Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
                    .background(colorSeleccionado)
            )
        }
    }

}

@Composable
fun ListaColores(onColorSeleccionado: (Color) -> Unit) {
    val colores = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)

    LazyColumn () {
        items(colores) { color ->
            Button(
                onClick = { onColorSeleccionado(color) },
                colors = ButtonDefaults.buttonColors(containerColor = color)
            ) {
                Text(if (color == Color.Red) {"Rojo"} else if (color == Color.Green) {"Verde"} else if (color == Color.Blue) {"Azul"} else {"Amarillo"}, color = Color.White)
            }
        }
    }
}


