package com.example.airbooking

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.airbooking.data.User
import com.example.airbooking.events.UserEvent
import com.example.airbooking.ui.theme.AirBookingTheme
import com.example.airbooking.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            AirBookingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    SigningIn()
                }
            }
        }
    }

    @Composable
    fun SigningIn() {
        val viewModel: UserViewModel = hiltViewModel<UserViewModel>()

        val mContext = LocalContext.current
        val fontFamily = FontFamily(
            Font(R.font.cooper_black_regular, FontWeight.Normal)
        )
        var username by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }
        var errorMessage by remember { mutableStateOf("") }
        var isError by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .wrapContentHeight()
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign In",
                    fontFamily = fontFamily,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it
                                    if (username.isEmpty()) {
                                        isError = true
                                        errorMessage = "The Field is Empty"
                                    } else {
                                        isError = false
                                        errorMessage = ""
                                    } },
                    singleLine = true,
                    supportingText = {
                        if (isError) {
                            Text(
                                text = errorMessage,
                                modifier = Modifier.fillMaxWidth(),
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    },
                    trailingIcon = {
                        if (isError) {
                            Icon(Icons.Filled.Error, "Error", tint = MaterialTheme.colorScheme.error)
                        }
                    },
                    isError = isError,
                    leadingIcon = {Icon( imageVector = Icons.Default.AccountCircle, contentDescription = null)},
                    label = { Text(text = "Username") },
                    modifier = Modifier.fillMaxWidth(),


                )
                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    leadingIcon = {Icon( imageVector = Icons.Default.Lock, contentDescription = null)},
                    label = { Text(text = "Password") },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        IconButton(onClick = {
                            showPassword = !showPassword
                        }) {
                            Icon(imageVector  = if (showPassword)
                                Icons.Filled.Visibility
                            else
                                Icons.Filled.VisibilityOff, "")

                        }
                    }
                )
                ElevatedButton(onClick = {

                    val isValid = viewModel.onEvent(UserEvent.ValidateUser(User(username = username, passwordHash = password)))
                    Log.d("What's Inside isValid", isValid.toString())
//                    if (isValid) {
//                        mContext.startActivity(Intent(mContext, DashboardActivity::class.java))
//                    }
//                    else
//                        Toast.makeText(mContext, "Invalid User", Toast.LENGTH_LONG).show()

                }) {
                    Text(text = "Next")
                }
            }

        }
    }


}