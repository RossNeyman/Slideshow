package com.example.slideshow

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

object Datasource {
    @Composable
    fun loadSlides(): List<Slide> = listOf(
        Slide(R.drawable.cat_1, stringResource(R.string.cat_1_caption)),
        Slide(R.drawable.cat_2, stringResource(R.string.cat_2_caption)),
        Slide(R.drawable.cat_3, stringResource(R.string.cat_3_caption)),
        Slide(R.drawable.cat_4, stringResource(R.string.cat_4_caption)),
        Slide(R.drawable.cat_5, stringResource(R.string.cat_5_caption)),
        Slide(R.drawable.cat_6, stringResource(R.string.cat_6_caption)),
        Slide(R.drawable.cat_7, stringResource(R.string.cat_7_caption)),
        Slide(R.drawable.cat_8, stringResource(R.string.cat_8_caption)),
        Slide(R.drawable.cat_9, stringResource(R.string.cat_9_caption)),
        Slide(R.drawable.cat_10, stringResource(R.string.cat_10_caption)),
        Slide(R.drawable.cat_11, stringResource(R.string.cat_11_caption)),
    )
}