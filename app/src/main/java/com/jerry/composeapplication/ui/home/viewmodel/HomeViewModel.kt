package com.jerry.composeapplication.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import apiCall
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by Jerry  on 2021/5/20 13:48
 * Describe
 */
class HomeViewModel : ViewModel() {

    var list by mutableStateOf(listOf<Any>())

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            val articleDeffer = async { apiCall { Api.get().getHomeArticleList() } }
            val articleRes = articleDeffer.await()
            list = mutableListOf<Any>().apply {
                addAll(articleRes.data!!.datas)
            }
        }

    }
}