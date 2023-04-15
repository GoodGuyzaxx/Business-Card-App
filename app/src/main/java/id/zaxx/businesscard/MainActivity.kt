package id.zaxx.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.zaxx.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardMainApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardMainApp(){
    val image = painterResource(id =R.drawable.android_logo )
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = image,
                contentDescription =null,
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
            )
            BusinessCardTitle(name = stringResource(id = R.string.full_name), title = stringResource(R.string.title) )
        }
    }
        Column(verticalArrangement = Arrangement.Bottom,modifier = Modifier
            .padding(bottom = 50.dp)
            .fillMaxSize()) {
            BusinessCardInformation(info = stringResource(id = R.string.phone), icon = Icons.Default.Phone)
            BusinessCardInformation(info = stringResource(id = R.string.web), icon = Icons.Filled.AddCircle)
            BusinessCardInformation(info = stringResource(id = R.string.email), icon = Icons.Default.Email)
        }
}

@Composable
fun BusinessCardTitle(name: String,title:String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text =name, fontSize = 32.sp, fontFamily = FontFamily.SansSerif, color = Color.White)
        Text(text = title, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.faded_poster) , modifier = Modifier.padding(top = 5.dp))
    }
}

@Composable
fun BusinessCardInformation(info:String,icon:ImageVector){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 80.dp, top = 15.dp, bottom = 5.dp)) {
        Icon(imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(end = 10.dp))
        Text(text = info, color = Color.White )
    }
}

//@Composable
//fun unitTextIcon(){
//}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardMainApp()
//        BusniessCardTitle(name = stringResource(id = R.string.full_name), title = stringResource(id = R.string.title))
    }
}