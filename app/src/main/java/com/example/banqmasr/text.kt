package com.example.banqmasr

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.core.net.toUri

@Composable
fun Text1(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        color = Color.Gray,
        text = stringResource(R.string.forget),
        textDecoration = TextDecoration.Underline,
        modifier = modifier.clickable {
            Toast.makeText(context, "يافرحه امك بيك", Toast.LENGTH_SHORT).show()
        }
    )
}

@Composable
fun Text2(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Text(
        text = buildAnnotatedString {
            append(stringResource(R.string.need_help))
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(stringResource(R.string.contact_us))
            }
        },
        modifier = Modifier.clickable {
            val intent = Intent(
                Intent.ACTION_VIEW,
                "https://www.banquemisr.com".toUri()
            )
            context.startActivity(intent)
        }
    )
}
