package org.disf.app.hammer_system.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import org.disf.app.hammer_system.data.NetworkConfig
import org.disf.app.hammer_system.data.ext.addClient
import org.disf.app.hammer_system.data.ext.addJsonConverter
import org.disf.app.hammer_system.data.network.api.FoodApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(NetworkConfig.BASE_URL)
        .addJsonConverter()
        .addClient()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideFoodApi(retrofit: Retrofit): FoodApi =
        retrofit.create(FoodApi::class.java)
}
