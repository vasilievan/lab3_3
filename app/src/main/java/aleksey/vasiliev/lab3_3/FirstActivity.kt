package aleksey.vasiliev.lab3_3

import aleksey.vasiliev.lab3_3.Shared.BottomNavigationBar
import aleksey.vasiliev.lab3_3.ui.theme.Lab3_3Theme
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(this).apply {
                setContent {
                    Lab3_3Theme {
                        Scaffold(
                            topBar = { TopAppBar(title = { Text("First") }) },
                            bottomBar = { BottomNavigationBar(this@FirstActivity) },
                            content = { Layout() })
                    }
                }
                id = R.id.activity_first
            }
        )

    }

    @Composable
    fun Layout() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = {
                startActivity(
                    Intent(
                        this@FirstActivity,
                        SecondActivity::class.java
                    )
                )
            }) {
                Text("Second")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Lab3_3Theme {
            BottomNavigationBar(this)
        }
    }

    override fun onBackPressed() {
        finish()
    }
}

