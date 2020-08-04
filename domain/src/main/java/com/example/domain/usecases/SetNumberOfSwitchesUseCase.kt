package com.example.domain.usecases

import com.example.domain.model.SwitchRepository
import javax.inject.Inject

class SetNumberOfSwitchesUseCase @Inject constructor(
    private val switchRepository: SwitchRepository
) {

    suspend fun setNumber(number: Long) {
        return switchRepository.setNumberOfSwitches(number)
    }
}