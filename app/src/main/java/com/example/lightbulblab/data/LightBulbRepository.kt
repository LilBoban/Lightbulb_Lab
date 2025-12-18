package com.example.lightbulblab.data

import javax.inject.Inject

interface LightBulbRepository {
    suspend fun setColor(colorName : String): Boolean
    suspend fun setBrightness(level: Int): Boolean
    suspend fun turnOn(): Boolean
    suspend fun turnOff(): Boolean
}

class LightBulbRepositoryImpl @Inject constructor(
    private  val service: LightBulbService
): LightBulbRepository {

    override suspend fun setBrightness(level: Int): Boolean {
        return service.setBrightness(level).body() ?: false
    }

    override suspend fun setColor(colorName: String): Boolean {
        return service.setColor(colorName).body() ?: false
    }

    override suspend fun turnOn(): Boolean {
       return service.turnOn().body() ?: false
    }

    override suspend fun turnOff(): Boolean {
        return service.turnOff().body() ?: false
    }

}