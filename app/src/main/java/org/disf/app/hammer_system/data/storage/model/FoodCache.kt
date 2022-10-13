package org.disf.app.hammer_system.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.disf.app.hammer_system.domain.model.Food

@Entity(tableName = "food")
data class FoodCache(
    @PrimaryKey val id: String,
    val title: String,
    val imageSrc: String,
    val description: String,
)

fun FoodCache.toDomain(): Food = Food(
    id = id,
    title = title,
    imageSrc = imageSrc,
    description = description
)

fun Food.toData(): FoodCache = FoodCache(
    id = id,
    title = title,
    imageSrc = imageSrc,
    description = description
)