package com.tu_paquete.tu_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mi_primera_app.ui.theme.Mi_Primera_APPTheme
import com.example.mi_primera_app.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mi_Primera_APPTheme() {
                // Llamada a la función que contiene la UI
                WooperlandLoginScreen()
            }
        }
    }
}

@Composable
fun WooperlandLoginScreen() {
    Row(modifier = Modifier.fillMaxSize()) {
        // Sección de la izquierda con la imagen
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFFFEB3B)) // Color amarillo de fondo
        ) {
            Image(
                painter = painterResource(id = R.drawable.imglogin),
                contentDescription = "Wooperland",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Sección de la derecha con botones y pasos
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFE91E63)) // Color rosado de fondo
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Indicador de pasos
            StepsIndicator()

            Spacer(modifier = Modifier.height(24.dp))

            // Botones de inicio de sesión
            LoginButton("Continuar con Google",    R.drawable.imggoogle)
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar con Facebook",  R.drawable.imgfacebook)
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar con Microsoft", R.drawable.imgwindows)
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar como Invitado", R.drawable.imginvitado)
        }
    }
}

@Composable
fun StepsIndicator() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StepCircle(1, true)
        Spacer(modifier = Modifier.width(8.dp))
        StepCircle(2, false)
        Spacer(modifier = Modifier.width(8.dp))
        StepCircle(3, false)
    }
}

@Composable
fun StepCircle(stepNumber: Int, isActive: Boolean) {
    val color = if (isActive) Color.Yellow else Color.White
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(RoundedCornerShape(50))
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stepNumber.toString(), fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun LoginButton(text: String, iconRes: Int) {
    Button(
        onClick = { /* Acción del botón */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontWeight = FontWeight.Bold)
    }
}
