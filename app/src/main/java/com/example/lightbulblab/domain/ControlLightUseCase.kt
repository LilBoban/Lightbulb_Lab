package com.example.lightbulblab.domain

import com.example.lightbulblab.data.LightBulbRepository
import javax.inject.Inject

interface ControlLightUseCase {
    suspend fun switchLight (isOn : Boolean)
    suspend fun  changeColor (color : String)
}

class ControlLightUseCaseImpl @Inject constructor(
    private val repository: LightBulbRepository
): ControlLightUseCase{
    override suspend fun switchLight(isOn: Boolean) {
        if (isOn) repository.turnOn() else repository.turnOff()
    }

    override suspend fun changeColor(color: String) {
        repository.setColor(color)
    }
}