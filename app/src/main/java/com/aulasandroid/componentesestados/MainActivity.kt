package com.aulasandroid.componentesestados


import android.R.attr.label
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.componentesestados.ui.theme.ComponentesEstadosTheme
import com.aulasandroid.componentesestados.ui.theme.righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                   BasicComponentesScreen(modifier = Modifier .padding(innerPadding))
                    ComponentesEstadoScreen(modifier = Modifier .padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BasicComponentesScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .background(Color(220, 209, 132, 255))
        .fillMaxSize()
    ) {
        Text(modifier = Modifier
            .fillMaxWidth(),
            text = "Aulas android",
            fontSize = 32.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
            )
        Text(modifier = Modifier
            .align (Alignment.CenterHorizontally),
            text = "com JetPack compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0, 71, 124, 255),
            fontFamily = righteous
        )
    }
}

@Composable
fun ComponentesEstadoScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .background(Color.Black)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val nome = remember {
            mutableStateOf("")
        }

        TextField(
            value = nome.value,
            onValueChange = {
                novoValor -> Log.i("teste", novoValor)

                nome.value = novoValor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            placeholder = {
                Text("Digite seu nome")
            },
            label = {
                Text("Nome e sobrenome")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icone Pessoa",
                    tint = Color.Cyan
                )
            }


        )
    }
}

