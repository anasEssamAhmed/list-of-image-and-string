package com.example.unit3_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unit3_list.Database.database
import com.example.unit3_list.model.Affirmation
import com.example.unit3_list.ui.theme.PurpleGrey80
import com.example.unit3_list.ui.theme.Unit3_listTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit3_listTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun ImageWithString(affirmation: Affirmation) {
    Column(
        modifier = Modifier
            .wrapContentSize(align = Alignment.TopCenter)
            .padding(8.dp)
            //.background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(affirmation.imageResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .clip(shape = RoundedCornerShape(topStart = 9.dp, topEnd = 9.dp))
        )
        Text(
            text = stringResource(affirmation.stringResourceId),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = PurpleGrey80,
                    shape = RoundedCornerShape(bottomStart = 9.dp, bottomEnd = 9.dp)
                )
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
        )
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>) {
    LazyColumn{
        items(affirmationList){
            ImageWithString(it)
        }
    }
}

@Composable
fun AffirmationsApp() {
    AffirmationList(
        affirmationList = database().loadAffirmations()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Unit3_listTheme {
        AffirmationsApp()
    }
}