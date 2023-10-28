package com.example.airbooking

import android.content.Intent
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
import androidx.lifecycle.lifecycleScope
import com.example.airbooking.events.UserEvent
import com.example.airbooking.hashing.Guava
import com.example.airbooking.ui.theme.AirBookingTheme
import com.example.airbooking.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirBookingTheme {

                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SigningUp()
                }
            }
        }
    }



    @Composable
    fun SigningUp() {
        val mContext = LocalContext.current
        val viewModel: UserViewModel = hiltViewModel<UserViewModel>()
        val fontFamily = FontFamily(
            Font(R.font.cooper_black_regular, FontWeight.Normal)
        )
        var username by rememberSaveable { mutableStateOf("") }
        var password1 by rememberSaveable { mutableStateOf("") }
        var password2 by rememberSaveable { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }
        var isError1 by remember { mutableStateOf(false) }
        var isError2 by remember { mutableStateOf(false) }
        var errorMessage by remember { mutableStateOf("") }
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
                    text = "Sign Up",
                    fontFamily = fontFamily,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
                OutlinedTextField(
                    value = username,
                    onValueChange = {
                        username = it
                        lifecycleScope.launch {
                            if (username.isEmpty()) {
                                isError1 = true
                                errorMessage = "The field is empty"
                            }
                            else if (username.length < 5) {
                                    isError1 = true
                                    errorMessage = "The username should have at least 5 characters"
                                } else {
                                    val isUnique = viewModel.onEvent(UserEvent.UniqueUsername(username))
                                    Log.d("What's Inside isUnique", isUnique.toString())

//                                    if (!isUnique) {
//                                        isError1 = true
//                                        errorMessage = "The username is not unique"
//                                    }  else {
//                                    isError1 = false
//                                    errorMessage = ""
//                                }
                            }
                        }
                                    },
                    singleLine = true,
                    supportingText = {
                        if (isError1) {
                            Text(
                                text = errorMessage,
                                modifier = Modifier.fillMaxWidth(),
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    },
                    trailingIcon = {
                        if (isError1) {
                            Icon(Icons.Filled.Error, "Error", tint = MaterialTheme.colorScheme.error)
                        }
                    },
                    leadingIcon = { Icon( imageVector = Icons.Default.AccountCircle, contentDescription = null) },
                    label = { Text(text = "Username") },
                    isError = isError1,
                    modifier = Modifier.fillMaxWidth(),

                    )
                OutlinedTextField(
                    value = password1,
                    onValueChange = {password1 = it},
                    leadingIcon = { Icon( imageVector = Icons.Default.Lock, contentDescription = null) },
                    label = { Text(text = "Password") },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        IconButton(onClick = {
                            showPassword = !showPassword
                        }) {
                            Icon(imageVector  = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff, "")
                        }
                    }
                )

                OutlinedTextField(
                    value = password2,
                    onValueChange = {
                        password2 = it
                        if (password2.isEmpty()) {
                            isError2 = true
                            errorMessage = "The field is empty"
                        } else {
                            if (password2.length < 5) {
                                isError2 = true
                                errorMessage = "The length of the password should be at least 5 characters"
                            }
                            else if (password1 != password2) {
                                isError2 = true
                                errorMessage = "The passwords don't match"
                            }
                            else {
                                isError2 = false
                                errorMessage = ""
                            }
                        }
                                    },
                    leadingIcon = { Icon( imageVector = Icons.Default.Lock, contentDescription = null) },
                    label = { Text(text = "Retype Password") },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth(),
                    isError = password1 != password2,
                    singleLine = true,
                    supportingText = {
                        if (isError2) {
                            Text(
                                text = errorMessage,
                                modifier = Modifier.fillMaxWidth(),
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    },
                    trailingIcon = {
                        if (isError2) {
                            Icon(Icons.Filled.Error, "Error", tint = MaterialTheme.colorScheme.error)
                        }
                        else {
                            IconButton(onClick = {
                                showPassword = !showPassword
                            }) {
                                Icon(imageVector  = if (showPassword)
                                    Icons.Filled.Visibility
                                else
                                    Icons.Filled.VisibilityOff, "")
                            }
                        }

                    }
                )
                ElevatedButton(onClick = {

                    val guava = Guava()
                    val hash = guava.hashingSha256(password1)
                    val return_ = viewModel.onEvent(UserEvent.EnterUser(username, hash))
                    Log.d("What's Inside Return Value of Entering A User", return_.toString())


                    mContext.startActivity(Intent(mContext, SignInActivity::class.java))
                }) {
                    Text(text = "Next")
                }
            }
        }
    }
}

