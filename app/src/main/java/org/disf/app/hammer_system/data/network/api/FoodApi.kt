package org.disf.app.hammer_system.data.network.api

import io.reactivex.Single
import org.disf.app.hammer_system.data.network.model.FoodMenuResponse
import retrofit2.http.GET

interface FoodApi {

    @GET("menu")
    fun getMenu(): Single<FoodMenuResponse>
}