package org.disf.app.hammer_system.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.disf.app.hammer_system.data.storage.AppDb
import org.disf.app.hammer_system.data.storage.dao.FoodDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StorageModule {

    @Singleton
    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ): AppDb = Room.databaseBuilder(
        context,
        AppDb::class.java,
        "food.db"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun providesFoodDao(appDb: AppDb): FoodDao = appDb.getFoodDao()
}