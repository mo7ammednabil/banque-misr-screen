package com.example.banqmasr

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banqmasr.ui.theme.BanqMasrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanqMasrTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Screen(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }

    override fun attachBaseContext(newBase: Context) {
        val sharedPref = newBase.getSharedPreferences("settings", Context.MODE_PRIVATE)
        val lang = sharedPref.getString("lang", "en") ?: "en"

        val context = LocaleManager.setLocale(newBase, lang)
        super.attachBaseContext(context)
    }

}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .padding(vertical = 64.dp)
    ) {
        AppBar()
        Spacer(modifier = Modifier.height(16.dp))
        AppTextField(
            value = email,
            onValueChange = { email = it },
            label = stringResource(id = R.string.username)
        )

        AppTextField(
            value = password,
            onValueChange = { password = it },
            label = stringResource(id = R.string.pass),
            isPassword = true
        )
        Text1(modifier = Modifier.padding(vertical = 16.dp))
        CustomButton(modifier = Modifier.padding(vertical = 16.dp), onClick = {
            Toast.makeText(context, "Hello ${email.substringBefore("@")}", Toast.LENGTH_SHORT).show()
        }, enable = checkEnable(email, password))
        Text2(modifier = Modifier.padding(vertical = 16.dp))
        Box(
            modifier = Modifier
                .padding(top = 40.dp)
                .padding(bottom = 32.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Photo(
                modifier = Modifier.padding(vertical = 16.dp),
                image = painterResource(id = R.drawable.our_products),
                text = stringResource(R.string.our_products)
            )
            Photo(
                modifier = Modifier.padding(vertical = 16.dp),
                image = painterResource(id = R.drawable.exchange_rate),
                text = stringResource(R.string.exchange_rate)
            )
            Photo(
                modifier = Modifier.padding(vertical = 16.dp),
                image = painterResource(id = R.drawable.security_tips),
                text = stringResource(R.string.security_tips)
            )
            Photo(
                modifier = Modifier.padding(vertical = 16.dp),
                image = painterResource(id = R.drawable.nearest_branch_or_atm),
                text = stringResource(R.string.nearest_branch_or_atm)
            )
        }
    }
}

fun checkEnable(email: String, password: String): Boolean {
    return email.isNotEmpty() && password.isNotEmpty()
}



@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    BanqMasrTheme {
        Screen()
    }
}