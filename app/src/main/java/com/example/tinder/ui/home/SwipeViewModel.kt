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
            SwipeCardModel(backgroundColor = Color.parseColor("#333333"), "Toyota Supra", R.drawable.ts),
            SwipeCardModel(backgroundColor = Color.parseColor("#333333"), "Dodge Charger", R.drawable.dch),
            SwipeCardModel(backgroundColor = Color.parseColor("#333333"), "Chevrolet Camaro", R.drawable.chc)
        )
    }

    private var currentIndex = 0

    fun getTopCard(): SwipeCardModel { return cardsList[currentIndex % cardsList.size] }

    fun getBottomCard(): SwipeCardModel { return cardsList[(currentIndex + 1) % cardsList.size] }

    fun swipe() {
        currentIndex += 1
    }

}