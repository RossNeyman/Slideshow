package com.example.slideshow

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Slide(
    @DrawableRes val imageRes: Int,
    val caption: String
)