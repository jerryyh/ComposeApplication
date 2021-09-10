package com.jerry.composeapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jerry.composeapplication.theme.ComposeApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                ComposeNavigation()
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(
        text = " $name", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center, modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    )
}


@Composable
fun FlexibleComposable() {
    Row(Modifier.fillMaxWidth()) {
        Box(
            Modifier
                .weight(2f)
                .height(50.dp)
                .background(Color.Blue)
        )
        Box(
            Modifier
                .weight(1f)
                .height(50.dp)
                .background(Color.Red)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
        Column(
            Modifier.fillMaxWidth()
        ) {
            ComposeNavigation()
            Greeting("首页")
            listItem()
            gridItem()
            ConstraintLayoutContent()
        }
    }
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()
        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(text.bottom, margin = 16.dp)
                }
                .offset(x = 20.dp)
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("Text",
            Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top, margin = 16.dp)
                }
                .offset(x = 20.dp))
    }
}


@Composable
fun WithConstraintsComposable() {
    BoxWithConstraints {
        Text("My minHeight is minHeight while my maxWidth is maxWidth")
    }
}

@Composable
fun gridItem() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "我")
        Text(text = "爱")
        Text(text = "中")
        Text(text = "国")
    }
}

@Composable
fun listItem() {
    Box {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .size(width = 250.dp, height = 100.dp)

        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "这是图片",
                modifier = Modifier
//                    .fillMaxHeight()
                    .height(80.dp)
                    .width(80.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = "Alfred Sisley",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,

                    )
                Text(
                    text = "3 minutes ago", fontSize = 15.sp, color = Color.Gray,
                    modifier = Modifier
                        .paddingFromBaseline(top = 10.dp)
                        .offset(x = 9.dp)

                )
            }
        }
    }
}