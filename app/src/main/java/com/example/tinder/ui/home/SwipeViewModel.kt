package com.example.tinder.ui.home

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tinder.R

class SwipeViewModel: ViewModel() {
    init {
        getCardsList()
        Log.i("SwipeViewModel", "SwipeViewModel created!")
    }
    private lateinit var cardsList: MutableList<SwipeCardModel>

    private fun getCardsList() {
        cardsList = mutableListOf(
            SwipeCardModel(backgroundColor = Color.parseColor("#222222"), "Marina Laswick", R.drawable.d1),
            SwipeCardModel(backgroundColor = Color.parseColor("#222222"), "Polina Romanova", R.drawable.d2),
            SwipeCardModel(backgroundColor = Color.parseColor("#222222"), "Kristina Minaeva", R.drawable.d3)
        )
    }

    private var currentIndex = 0

    fun getTopCard(): SwipeCardModel { return cardsList[currentIndex % cardsList.size] }

    fun getBottomCard(): SwipeCardModel { return cardsList[(currentIndex + 1) % cardsList.size] }

    fun swipe() {
        currentIndex += 1
    }

}