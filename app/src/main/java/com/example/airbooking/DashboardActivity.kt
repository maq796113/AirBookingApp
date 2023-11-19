package com.example.airbooking

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.airbooking.data.User
import com.example.airbooking.ui.theme.AirBookingTheme
import com.example.airbooking.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirBookingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DashboardLayout()
                }
            }
        }
    }
}

@Composable
fun UserProfilePic(
    user: User?,
    modifier: Modifier = Modifier
){

    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(45.dp)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer.copy(0.03f),
                shape = CircleShape
            )
            .border(1.dp, Color.LightGray, CircleShape)
        ,
        contentAlignment = Alignment.Center
    ){
        if (user != null) {
            if (user.profilePictureUri != null){
                AsyncImage(
                    Uri.parse(user.profilePictureUri),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .matchParentSize()
                )
            }else{
                Text(
                    text = "Null",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }
    }
}

@Composable
fun DashboardLayout(
    viewModel: UserViewModel = hiltViewModel()
) {
    UserProfilePic(user = viewModel.session.getActiveSession()?.user)

}