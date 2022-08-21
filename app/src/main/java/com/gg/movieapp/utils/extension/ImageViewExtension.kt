package com.gg.movieapp.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gg.movieapp.R

fun ImageView.loadImageWithUrl(url: String) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.bg_splashscreen)
        .into(this)
}
