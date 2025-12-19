package com.example.lightbulblab.domain

import com.example.lightbulblab.data.LightBulbRepository
import javax.inject.Inject

class ChangeColorUseCase @Inject constructor(
    private val repository: LightBulbRepository
) {
    suspend operator fun invoke(color: String): Boolean {
        return repository.setColor(color)
    }
}