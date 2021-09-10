package com.jerry.composeapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.jerry.composeapplication.R
import com.jerry.composeapplication.theme.Colors
import com.jerry.composeapplication.ui.home.model.Article
import com.jerry.composeapplication.ui.home.viewmodel.HomeViewModel
import com.jerry.composeapplication.widget.TitleBar
import java.lang.StringBuilder

/**
 * Created by Jerry  on 2021/5/20 11:35
 * Describe
 */

@Composable
fun Square(navController: NavHostController) {
    val viewModel: HomeViewModel = viewModel()
    Column(
        Modifier
            .fillMaxSize()
            .background(Colors.background)
    ) {
        TitleBar(title = "广场",
            icon = R.drawable.ic_search,
            onIconClick = {
//                navController.navigate("search")
            }
        )
        LazyColumn {
            // Add 5 items
            items(20) { index ->
                listItem()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun listItem() {
    Box(modifier = Modifier.clickable { }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "这是图片",
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .padding(start = 20.dp, top = 10.dp, bottom = 10.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Alfred Sisley",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,

                    )
                Text(
                    text = "3 minutes ago 3 minutes ago 3 minutes ago",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .paddingFromBaseline(top = 10.dp)
                        .offset(x = 1.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Colors.redLppz,
                    contentColor = Color.White
                ), modifier = Modifier.padding(end = 20.dp)
            ) {
                Text(text = "关注")
            }
        }
    }
}
