package com.davangu.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davangu.firstapp.ui.theme.FirstAppTheme
import com.davangu.firstapp.ui.theme.LightGreen
import com.davangu.firstapp.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .fillMaxWidth())
                    {
                        Greeting(
                            name = "Clase",
                            modifier = Modifier
                                .padding(innerPadding)
                        )
                        BoxBadge()
                        TopBarRow()
                    }
                }
            }
        }
    }
}

@Composable
fun BoxBadge() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(Purple40)
            .padding(8.dp),
        //contentAlignment = Alignment.BottomEnd
    ) {
        Text(
            text = "Foto",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .background(Color.White)
        )
        // Badge en la esquina
        Text(
            text = "3",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .background(
                    color = LightGreen,
                    shape = CircleShape
                )
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun TopBarRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painterResource(R.drawable.ic_arrow_back),
            contentDescription = "Atrás")
        // Text ocupa el centro disponible, desplazando al
        // icono Search completamente a la parte derecha
        Text(
            text = "Título de pantalla",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(painterResource(R.drawable.ic_search),
            contentDescription = "Buscar")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAppTheme {
        Greeting("Android")
    }
}