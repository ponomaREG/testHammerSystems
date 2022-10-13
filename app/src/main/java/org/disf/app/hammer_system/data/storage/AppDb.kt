package org.disf.app.hammer_system.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import org.disf.app.hammer_system.data.storage.dao.FoodDao
import org.disf.app.hammer_system.data.storage.model.FoodCache

@Database(
    entities = [
        FoodCache::class
    ],
    version = 2
)
abstract class AppDb : RoomDatabase() {

    abstract fun getFoodDao(): FoodDao
}