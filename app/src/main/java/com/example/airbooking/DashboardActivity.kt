package com.example.airbooking

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getString
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.airbooking.data.User
import com.example.airbooking.ui.theme.AirBookingTheme
import com.example.airbooking.viewModel.UserViewModel
import com.google.relay.compose.RowScopeInstanceImpl.align
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirBookingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
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
                    contentDescription = null
                )
            }else{
                AsyncImage(
                    model = getString(LocalContext.current, R.string.man_silhouette),
                    contentDescription = "Man's Silhoutte/Facebook Default Image",
                    contentScale = ContentScale.Crop,
                    alignment=Alignment.Center,
                    modifier = Modifier
                        .width(Dp(125.5f))
                        .padding(10.dp)
                        .aspectRatio(1920f / 1712f)
                        .clip(CircleShape)

                )
            }
        }
    }
}

@Composable
fun DashboardLayout(
    viewModel: UserViewModel = hiltViewModel()
) {
    Log.d("Active Session", viewModel.session.getActiveSession()?.user.toString())
    Column(
        modifier = Modifier.align(Alignment.Top)
    ) {
        UserProfilePic(user = viewModel.session.getActiveSession()?.user)
    }
}