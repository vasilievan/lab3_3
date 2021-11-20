package aleksey.vasiliev.lab3_3

import aleksey.vasiliev.lab3_3.Shared.BottomNavigationBar
import aleksey.vasiliev.lab3_3.ui.theme.Lab3_3Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview

class About : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(this).apply {
                setContent {
                    Lab3_3Theme {
                        Scaffold(
                            topBar = { TopAppBar(title = { Text("About") }) },
                            bottomBar = { BottomNavigationBar(this@About) },
                            content = { Spacer(modifier = Modifier.fillMaxSize()) }
                        )
                    }
                }
                id = R.id.activity_about
            }
        )
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
        super.onBackPressed()
    }
}

