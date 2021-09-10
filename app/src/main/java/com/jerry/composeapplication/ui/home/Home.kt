package com.jerry.composeapplication.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
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
fun Home(navController: NavHostController) {
    val viewModel: HomeViewModel = viewModel()
    Column(
        Modifier
            .fillMaxSize()
            .background(Colors.background)
    ) {
        TitleBar(title = "首页",
            icon = R.drawable.ic_search,
            onIconClick = {
//                navController.navigate("search")
            }
        )
        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(Colors.white)
        ) {
            itemsIndexed(viewModel.list) { index, item ->
                ArticleItem(navController, item as Article) {
//                    viewModel.collect(item)
                }
            }
        }

    }
}

@Composable
fun ArticleItem(
    navController: NavHostController,
    article: Article,
    onCollectClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {

            }
    ) {
        Column(
            Modifier.padding(16.dp, 10.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                article.tags.forEach {
                    Text(
                        it.name,
                        Modifier
                            .align(Alignment.CenterVertically)
                            .border(0.5.dp, it.getColor(), RoundedCornerShape(3.dp))
                            .padding(2.dp, 1.dp),
                        it.getColor(),
                        10.sp
                    )
                    Spacer(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(8.dp)
                            .height(0.dp)
                    )
                }
                Text(
                    article.getAuthor(),
                    Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    Colors.text_h2,
                    12.sp
                )
                Spacer(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(10.dp)
                        .height(0.dp)
                )
                Text(
                    article.niceDate,
                    Modifier.align(Alignment.CenterVertically),
                    Colors.text_h2,
                    12.sp
                )
            }
            Text(
                text = article.title,
                Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                Colors.text_h1,
                15.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                val chapter = StringBuilder(article.superChapterName)
                if (article.superChapterName.isNotEmpty() && article.chapterName.isNotEmpty()) {
                    chapter.append(" / ")
                }
                chapter.append(article.chapterName)
                Text(
                    text = chapter.toString(),
                    Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    Colors.text_h2,
                    12.sp
                )
                val iconRes = if (article.collect) R.drawable.ic_like_fill else R.drawable.ic_like
                val tint = if (article.collect) Colors.red else Colors.text_h2
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = "收藏",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            onCollectClick.invoke()
                        },
                    tint = tint

                )
            }

        }
    }

}