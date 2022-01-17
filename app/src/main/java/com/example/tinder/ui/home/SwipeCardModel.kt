package com.example.tinder.ui.home

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes

data class SwipeCardModel (
    @ColorInt val backgroundColor: Int,
    val cardText: String,
    @DrawableRes val image: Int
)