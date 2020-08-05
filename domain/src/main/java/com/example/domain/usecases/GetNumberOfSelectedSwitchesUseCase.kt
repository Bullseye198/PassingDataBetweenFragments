package com.example.domain.usecases

import com.example.domain.model.SwitchRepository
import javax.inject.Inject

class GetNumberOfSelectedSwitchesUseCase @Inject constructor(
    private val switchRepository: SwitchRepository
) {

    suspend fun getNumberOfSelectedSwitches(): MutableList<Int> {
        return switchRepository.getNumberOfSelectedSwitches()
    }
}