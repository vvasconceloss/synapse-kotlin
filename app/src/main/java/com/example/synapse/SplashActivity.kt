package com.example.synapse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.synapse.ui.theme.SynapseTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SynapseTheme {
                ScreenSplash(this)
            }
        }
    }

    @Composable
    private fun ScreenSplash(activity: ComponentActivity) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.synapse_logo),
                    contentDescription = "Synapse Logo",
                    contentScale = ContentScale.Crop
            )
        }

        LaunchedEffect(Unit) {
            delay(3000L)
            navigateToMainActivity(activity)
        }
    }

    private fun navigateToMainActivity(activity: ComponentActivity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    @Preview(showBackground = true)
    @Composable
    fun ScreenSplashPreview() {
        SynapseTheme {
            ScreenSplash(ComponentActivity())
        }
    }
}
