package org.disf.app.hammer_system.data.network.model

import kotlinx.serialization.SerialName
import org.disf.app.hammer_system.domain.model.Food

@kotlinx.serialization.Serializable
data class FoodNetwork(

    @SerialName("_id") val id: String,
    @SerialName("menuname") val name: String,
    @SerialName("description") val description: String,
    @SerialName("images") val images: List<String>,
)

fun FoodNetwork.toDomain() = Food(
    id = id,
    title = name,
    description = description,
    imageSrc = images.getOrElse(0) { "https://i2.photo.2gis.com/images/branch/8/1125899937953652_453b.jpg" }
)

@kotlinx.serialization.Serializable
data class FoodMenuResponse(
    @SerialName("Total Menu") val totalMenu: Int,
    @SerialName("Result") val result: List<FoodNetwork>
)