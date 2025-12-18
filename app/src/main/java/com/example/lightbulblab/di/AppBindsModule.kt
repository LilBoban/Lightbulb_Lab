package com.example.lightbulblab.di

import com.example.lightbulblab.data.LightBulbRepository
import com.example.lightbulblab.data.LightBulbRepositoryImpl
import com.example.lightbulblab.domain.ControlLightUseCase
import com.example.lightbulblab.domain.ControlLightUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindLightRepository (impl: LightBulbRepositoryImpl) : LightBulbRepository

    @Binds
    fun bindControlLightUseCase (impl: ControlLightUseCaseImpl) : ControlLightUseCase
}