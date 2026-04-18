package com.example.banqmasr

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier
) {
    var showPassword by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label
            )
        },

        visualTransformation =
            if (isPassword && !showPassword)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,

        trailingIcon = {
            if (isPassword) {
                Icon(
                    imageVector =
                        if (showPassword)
                            Icons.Filled.Visibility
                        else
                            Icons.Filled.VisibilityOff,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        showPassword = !showPassword
                    }
                )
            }
        },

        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    )
}


@Preview(showSystemUi = true)
@Composable
private fun TextFieldPrev() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column() {
        AppTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email"
        )

        AppTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            isPassword = true
        )
    }
}