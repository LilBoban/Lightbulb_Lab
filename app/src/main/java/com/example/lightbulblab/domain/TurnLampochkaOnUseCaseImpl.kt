package com.example.lightbulblab.domain

import com.example.lightbulblab.data.LightBulbRepository
import jakarta.inject.Inject

interface TurnLampochkaOnUseCase {
    suspend operator fun invoke(): Boolean
}

class TurnLampochkaOnUseCaseImpl @Inject constructor(
    private val repository: LightBulbRepository
) : TurnLampochkaOnUseCase {

    override suspend operator fun invoke(): Boolean =
        repository.turnOn()

}