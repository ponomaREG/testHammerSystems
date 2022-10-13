package org.disf.app.hammer_system.presentation.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(src: String) {
    Glide.with(this)
        .load(src)
        .into(this)
}