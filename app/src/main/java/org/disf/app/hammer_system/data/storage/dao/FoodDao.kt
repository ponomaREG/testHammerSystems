package org.disf.app.hammer_system.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import org.disf.app.hammer_system.data.storage.model.FoodCache

@Dao
interface FoodDao {

    @Query("SELECT * FROM food;")
    fun getFood(): Single<List<FoodCache>>

    @Insert
    fun insert(foodCache: List<FoodCache>): Completable

    @Query("DELETE FROM food;")
    fun clearTable(): Completable
}