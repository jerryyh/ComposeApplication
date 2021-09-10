package com.jerry.composeapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.jerry.composeapplication.ui.home.Home
import com.jerry.composeapplication.ui.home.Square
import com.jerry.composeapplication.widget.BottomTab
import com.jerry.composeapplication.widget.Pager
import com.jerry.composeapplication.widget.PagerState

/**
 * Created by Jerry  on 2021/5/20 10:27
 * Describe
 */

class MainVIewModel :ViewModel(){
    val pagerState by mutableStateOf(PagerState(maxPage = 3))
}

@Composable
fun Main(navController: NavHostController) {
  Column(Modifier.fillMaxSize()) {
      val mainViewModel:MainVIewModel= viewModel()
      Pager(mainViewModel.pagerState,Modifier.weight(1f) ) {
          when(page){
              0->{
                  Home(navController)
              }
              1->{
                  Square(navController)
              }
              2->{
                  Home(navController)
              }
              3->{
                  Home(navController)
              }
          }
      }
      BottomTab(mainViewModel.pagerState.currentPage) {
          mainViewModel.pagerState.currentPage = it
      }
  }
}