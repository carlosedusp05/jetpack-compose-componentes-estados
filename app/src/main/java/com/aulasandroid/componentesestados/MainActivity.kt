package com.aulasandroid.componentesestados


import android.R.attr.checked
import android.R.attr.contentDescription
import android.R.attr.label
import android.R.attr.text
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
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
import kotlinx.coroutines.selects.select

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

    var corFundo by remember {
        mutableStateOf(Color(220, 209, 132, 255))
    }

    Column(modifier = modifier
        .background(corFundo)
        .fillMaxSize()
        .padding(0.dp,10.dp,0.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        var nome by remember {
            mutableStateOf("")
        }

        var idade by remember {
            mutableStateOf("")
        }

        var email by remember {
            mutableStateOf( "")
        }

        var jCompose by remember {
            mutableStateOf( false)
        }

        var xml by remember {
            mutableStateOf( false)
        }

//        var ios by remember {
//            mutableStateOf(false)
//        }
//
//        var android by remember {
//            mutableStateOf(false)
//        }
//
//        var wphone by remember {
//            mutableStateOf(false)
//        }

        var sOperacional by remember {
            mutableStateOf("ios")
        }

        var favoritado by remember {
            mutableStateOf(false)
        }

        TextField(
            value = nome,
            onValueChange = {
                novoValor -> Log.i("nome", novoValor)

                nome = novoValor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters
            ),
            placeholder = {
                Text("Digite seu nome")
            },

            singleLine = true,

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

        TextField(
            value = idade,
            onValueChange = {
                    novoValor -> idade = novoValor
            },

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            placeholder = {
                Text("Digite sua idade")
            },

            singleLine = true,

            label = {
                Text("Idade")
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Icone Pessoa",
                    tint = Color.Cyan
                )
            },

            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Magenta,
                unfocusedTextColor = Color.Blue,
                focusedPlaceholderColor = Color.Red
            )
        )

        OutlinedTextField(
            value = email,

            onValueChange = { email = it },

            singleLine = true,

            label = {
                Text(text = "email")
            },

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Icone Email",
                    tint = Color.Cyan

                )
            },

            placeholder = {
                Text("Digite seu email")
            },

            shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Magenta,
                unfocusedTextColor = Color.Blue,
                focusedPlaceholderColor = Color.Red,
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Yellow
            )



        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(55.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        )  {
            Checkbox(
                checked = xml,
                onCheckedChange = { xml = it},

                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "JetPack Compose")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(55.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        )  {
            Checkbox(
                checked = jCompose,
                onCheckedChange = { jCompose = it},

                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "XML")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(55.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        )  {
            RadioButton(
                selected = sOperacional == "ios",
                onClick = {
                    sOperacional = "ios"
                }
            )

            Text(text = "IOS")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(55.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        )  {
            RadioButton(
                selected = sOperacional == "android",
                onClick = {
                   sOperacional = "android"
                }
            )

            Text(text = "Android")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(55.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        )  {
            RadioButton(
                selected = sOperacional == "wPhone",
                onClick = {
                    sOperacional = "wPhone"
                }
            )

            Text(text = "WindowsPhone")
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            Button(
                onClick = {
                    corFundo = Color(211, 106, 26, 255)
                },

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),

                border = BorderStroke(width = 1.dp, Color.Yellow),

                shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp),

            ) {
                Text(text = "Clique aqui!")

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Estrela",
                    tint = Color.Yellow
                )
            }

            OutlinedButton(
                onClick = {
                    corFundo = Color(220, 209, 132, 255)
                },

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),

                border = BorderStroke(width = 1.dp, Color.Yellow),

                shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp)

            ) {
                Text(text = "Não clique aqui")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            if (favoritado) {

                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable{
                            favoritado = false
                        },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite icon"
                )
            }else {

                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable{
                            favoritado = true
                        },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite border  icon"
                )
            }
        }
    }
}

