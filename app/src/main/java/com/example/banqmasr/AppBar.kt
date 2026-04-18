package com.example.banqmasr

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activity = context as Activity
    val sharedPref = context.getSharedPreferences("settings", Context.MODE_PRIVATE)


    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bm_icon),
            contentDescription = "Banq Masr Logo"
        )
        Text(
            text = stringResource(R.string.lang),
            style = TextStyle(
                color = Color.Red,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold

            ),
            modifier = Modifier.clickable {
                val currentLang = sharedPref.getString("lang", "en")

                val newLang = if (currentLang == "en") "ar" else "en"

                sharedPref.edit().putString("lang", newLang).apply()

                activity.recreate()
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppBarPreview() {
    AppBar()
}
