package org.disf.app.hammer_system.presentation.ext

import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import org.disf.app.hammer_system.R
import org.disf.app.hammer_system.domain.model.Category

fun ChipGroup.setCategories(chips: List<Category>) {
    this.removeAllViews()
    val layoutInflater = LayoutInflater.from(context)
    var counter = 0
    for (chip in chips) {
        this.addView(
            (layoutInflater.inflate(
                R.layout.item_category, this, false
            ) as Chip).also { chipView ->
                chipView.text = chip.title
                chipView.id = counter
                chipView.tag = chip.title
            }
        )
        counter++
    }
}