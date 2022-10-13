package org.disf.app.hammer_system.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.disf.app.hammer_system.data.repository.FoodRepositoryImpl
import org.disf.app.hammer_system.domain.repository.FoodRepository

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun bindsFoodRepository(foodRepositoryImpl: FoodRepositoryImpl): FoodRepository
}