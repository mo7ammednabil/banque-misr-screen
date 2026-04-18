package com.example.banqmasr

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(modifier: Modifier = Modifier , onClick: () -> Unit , enable : Boolean) {
    Button(
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        ),
        enabled = enable,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        onClick = {
            onClick()
        }

    ) {
        Text(text = stringResource(R.string.login))
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
private fun CustumBottomPreview() {
    CustomButton(
        modifier = TODO(),
        onClick = TODO(),
        enable = TODO()
    )
}