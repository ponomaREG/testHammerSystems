package org.disf.app.hammer_system.domain.repository

import io.reactivex.Observable
import io.reactivex.Single
import org.disf.app.hammer_system.domain.model.Banner
import org.disf.app.hammer_system.domain.model.Category
import org.disf.app.hammer_system.domain.model.Food

interface FoodRepository {

    fun loadFoods(): Observable<List<Food>>
    fun loadCategories(): Single<List<Category>>
    fun loadBanners(): Single<List<Banner>>
}