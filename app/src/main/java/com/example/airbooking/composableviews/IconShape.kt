package com.example.airbooking.composableviews

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.airbooking.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

/**
 * This composable was generated from the UI Package 'icon_shape'.
 * Generated code; do not edit directly
 */
@Composable
fun IconShape(
    modifier: Modifier = Modifier,
    onDisplayPictureIconTapped: () -> Unit = {},
    onDisplayPictureIconLongPressed: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        DisplayPictureIcon(
            onDisplayPictureIconTapped = onDisplayPictureIconTapped,
            onDisplayPictureIconLongPressed = onDisplayPictureIconLongPressed,
            modifier = Modifier
                .boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -1.0.dp,
                        y = -1.0.dp
                    )
                )
                .rowWeight(1.0f)
                .columnWeight(1.0f)
        )
    }
}

@Preview(widthDp = 36, heightDp = 36)
@Composable
private fun IconShapePreview() {
    MaterialTheme {
        RelayContainer {
            IconShape(
                onDisplayPictureIconTapped = {},
                onDisplayPictureIconLongPressed = {},
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun DisplayPictureIcon(
    onDisplayPictureIconTapped: () -> Unit,
    onDisplayPictureIconLongPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.icon_shape_display_picture_icon),
        modifier = modifier
            .tappable(
                onTap = onDisplayPictureIconTapped,
                onLongPress = onDisplayPictureIconLongPressed
            )
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}
