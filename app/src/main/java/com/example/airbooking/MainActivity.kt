package com.example.airbooking

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.airbooking.ui.theme.AirBookingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AirBookingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    WelcomeScreen()
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen() {
    val fontFamily = FontFamily(
        Font(R.font.cooper_black_regular, FontWeight.Normal)
    )

    val backgroundImage = painterResource(id = R.drawable.airplane_window)

    Image(
        painter = backgroundImage,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
    )
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        

    ){
        
        Text(
            text = "Welcome To A&J Airline Ticket Booking Service",
            color = colorResource(id = R.color.welcome_text),
            fontSize = 30.sp,
            fontFamily = fontFamily,
            textAlign = TextAlign.Center
        )
        val mContext = LocalContext.current

        ElevatedButton(
            onClick = {
                      mContext.startActivity(Intent(mContext, SignInActivity::class.java))
            },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black))
        ) {

            Text(
                text = "Sign In",
                color = Color.White
            )
        }
        ElevatedButton(
            onClick = {
                mContext.startActivity(Intent(mContext, SignUpActivity::class.java))
            },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black))
        ) {

            Text(
                text = "Sign Up",
                color = Color.White
            )
        }

    }
}





