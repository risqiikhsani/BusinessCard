package test.risqiikhsani.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import test.risqiikhsani.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {

                    BusinessCardBox(Identity("Risqi Ikhsani", "Android Developer Extraordinaire","0831212121","@risqiikhsani","risqiikhsani16@gmail.com"))
                }
            }
        }
    }
}

data class Identity(val name: String, val title: String,val phonenumber: String, val twitter: String,val email: String)

@Composable
fun BusinessCardBox(msg: Identity) {
    Box(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Android",
                modifier = Modifier
                    .size(200.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = msg.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = msg.title)
            Spacer(modifier = Modifier.height(100.dp))
            ContactInfoRow(
                icon = painterResource(R.drawable.phone_logo),
                text = msg.phonenumber
            )
            ContactInfoRow(
                icon = painterResource(R.drawable.share_logo),
                text = msg.twitter
            )
            ContactInfoRow(
                icon = painterResource(R.drawable.email_logo),
                text = msg.email
            )
        }

    }
}

@Composable
fun ContactInfoRow(icon: Painter, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {

    }
}