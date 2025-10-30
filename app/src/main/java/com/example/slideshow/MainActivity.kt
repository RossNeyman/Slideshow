package com.example.slideshow

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.slideshow.ui.theme.SlideshowTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideshowTheme {
                Slideshow()
            }
        }
    }
}

@Composable
fun Slideshow() {
    val images = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_5
    )
    val captions = listOf(
        R.string.cat_1_caption,
        R.string.cat_2_caption,
        R.string.cat_3_caption,
        R.string.cat_4_caption,
        R.string.cat_5_caption
    )
    require(images.size == captions.size)
    val imageCount = images.size
    var currImageIndex by remember { mutableIntStateOf(0) }
    var searchIndex by remember { mutableStateOf("") }

    fun nextImage() {
        currImageIndex = (currImageIndex + 1) % imageCount
    }

    fun prevImage() {
        currImageIndex = (currImageIndex - 1 + imageCount) % imageCount
    }

    fun chooseImage() {
        var searchIndexToInt = (searchIndex.toIntOrNull()) ?: 1
        if (searchIndexToInt > imageCount) {
            searchIndexToInt = 1
        }
        currImageIndex = searchIndexToInt - 1
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[currImageIndex]),
            contentDescription = captions[currImageIndex].toString(),
            modifier = Modifier.fillMaxWidth().height(260.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.height(12.dp))

        Text(
            text = "Image ${currImageIndex + 1} / $imageCount",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(captions[currImageIndex]),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { prevImage() }) { Text("Back") }
            Button(onClick = { nextImage() }) { Text("Next") }
        }

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = searchIndex,
                onValueChange = { searchIndex = it.filter { ch -> ch.isDigit() }.take(3) },
                label = { Text("Go to # (1..$imageCount)") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            Button(onClick = { chooseImage() }) { Text("Go") }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlideshowTheme {
        Slideshow()
    }
}