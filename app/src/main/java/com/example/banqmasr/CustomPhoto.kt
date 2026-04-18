package com.example.banqmasr

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun Photo(modifier: Modifier = Modifier, image : Painter, text : String) {
    Card(modifier = modifier.width(80.dp) , colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.background
    )) {
        Column(modifier = modifier ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = "Photo"
            )
            Text(text = text)
        }
    }
}