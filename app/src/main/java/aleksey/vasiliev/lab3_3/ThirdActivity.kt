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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3_3Theme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Third") }) },
                    bottomBar = { BottomNavigationBar(this) },
                    content = { Layout() })
            }
        }
    }

    @Composable
    fun Layout() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = {
                val intent = Intent(this@ThirdActivity, FirstActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }) {
                Text("First")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { finish() }) {
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
}

