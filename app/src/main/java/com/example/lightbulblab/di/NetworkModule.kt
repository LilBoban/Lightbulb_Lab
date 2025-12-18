package com.example.lightbulblab.di

import com.example.lightbulblab.data.LightBulbService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
object NetworkModule {
    @Provides
    fun provideDogsService(): LightBulbService =
        Retrofit.Builder()
            .baseUrl("http://195.133.53.179:1337/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
}