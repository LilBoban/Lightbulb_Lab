package com.example.lightbulblab.data.domain

import com.example.lightbulblab.data.LightBulbRepository
import jakarta.inject.Inject

interface TurnLampochkaOffUseCase {
    suspend operator fun invoke(): Boolean
}

class TurnLampochkaOffUseCaseImpl @Inject constructor(
    private val repository: LightBulbRepository
) : TurnLampochkaOffUseCase {

    override suspend operator fun invoke(): Boolean =
        repository.turnOff()
}
