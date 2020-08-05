package com.example.domain.usecases

import com.example.domain.model.SwitchRepository
import javax.inject.Inject

class IncreaseNumberOfSelectedSwitchesUseCase @Inject constructor(
    private val switchRepository: SwitchRepository
) {

    suspend fun increaseNumbers() {
        return switchRepository.increaseNumberOfSwitches()
    }
}