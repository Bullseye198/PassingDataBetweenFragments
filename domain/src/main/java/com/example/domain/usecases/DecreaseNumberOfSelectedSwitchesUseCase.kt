package com.example.domain.usecases

import com.example.domain.model.SwitchRepository
import javax.inject.Inject

class DecreaseNumberOfSelectedSwitchesUseCase @Inject constructor(
    private val switchRepository: SwitchRepository
) {

    suspend fun decreaseNumbers() {
        return switchRepository.decreaseNumberOfSwitches()
    }
}