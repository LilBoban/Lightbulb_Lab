package com.example.lightbulblab.domain

import com.example.lightbulblab.data.LightBulbRepository
import javax.inject.Inject

class SwitchLightUseCase @Inject constructor(
    private val repository: LightBulbRepository
) {
    suspend operator fun invoke(isOn: Boolean): Boolean {
        return if (isOn) repository.turnOn() else repository.turnOff()
    }
}