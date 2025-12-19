package com.example.lightbulblab.domain

import com.example.lightbulblab.data.LightBulbRepository
import javax.inject.Inject

class ChangeBrightnessUseCase @Inject constructor(
    private val repository: LightBulbRepository
) {
    suspend operator fun invoke(level: Int): Boolean {
        return repository.setBrightness(level)
    }
}