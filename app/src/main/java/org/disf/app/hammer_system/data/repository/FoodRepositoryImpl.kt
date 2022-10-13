package org.disf.app.hammer_system.data.repository

import io.reactivex.Observable
import io.reactivex.Single
import org.disf.app.hammer_system.data.network.api.FoodApi
import org.disf.app.hammer_system.data.network.model.FoodNetwork
import org.disf.app.hammer_system.data.network.model.toDomain
import org.disf.app.hammer_system.data.storage.dao.FoodDao
import org.disf.app.hammer_system.data.storage.model.FoodCache
import org.disf.app.hammer_system.data.storage.model.toData
import org.disf.app.hammer_system.data.storage.model.toDomain
import org.disf.app.hammer_system.domain.model.Banner
import org.disf.app.hammer_system.domain.model.Category
import org.disf.app.hammer_system.domain.model.Food
import org.disf.app.hammer_system.domain.repository.FoodRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodApi: FoodApi,
    private val foodDao: FoodDao
) : FoodRepository {

    override fun loadFoods(): Observable<List<Food>> {
        val daoSource = foodDao.getFood().map {
            it.map(FoodCache::toDomain)
        }
        val networkSource = foodApi.getMenu().map {
            it.result.map(FoodNetwork::toDomain)
        }.flatMap {
            foodDao.clearTable()
                .andThen(foodDao.insert(it.map(Food::toData)).andThen(Single.just(it)))
        }
        return Observable.concat(daoSource.toObservable(), networkSource.toObservable())
    }

    override fun loadCategories(): Single<List<Category>> {
        return Single.fromCallable {
            listOf(
                Category(
                    id = 1,
                    title = "Пицца",
                ),
                Category(
                    id = 2,
                    title = "Комбо",
                ),
                Category(
                    id = 3,
                    title = "Десерт",
                ),
                Category(
                    id = 4,
                    title = "Напитки",
                ),
                Category(
                    id = 5,
                    title = "Акции",
                ),
            )
        }.delay(1000, TimeUnit.MILLISECONDS)
    }

    override fun loadBanners(): Single<List<Banner>> {
        return Single.fromCallable {
            listOf(
                Banner(
                    id = 1,
                    bannerSrc = "https://pp.userapi.com/c837539/v837539211/36126/L0shz6JmA4I.jpg",
                ),
                Banner(
                    id = 2,
                    bannerSrc = "https://pp.userapi.com/c837539/v837539211/36126/L0shz6JmA4I.jpg",
                ),
                Banner(
                    id = 3,
                    bannerSrc = "https://pp.userapi.com/c837539/v837539211/36126/L0shz6JmA4I.jpg",
                ),
                Banner(
                    id = 4,
                    bannerSrc = "https://pp.userapi.com/c837539/v837539211/36126/L0shz6JmA4I.jpg",
                ),
            )
        }.delay(1000, TimeUnit.MILLISECONDS)
    }
}