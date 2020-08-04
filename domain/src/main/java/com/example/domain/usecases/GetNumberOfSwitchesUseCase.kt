package com.example.domain.usecases

import com.example.domain.model.SwitchRepository
import javax.inject.Inject

class GetNumberOfSwitchesUseCase @Inject constructor(
    private val switchRepository: SwitchRepository
) {

    suspend fun getNumber(getNumber: Long): Long? {
        return switchRepository.getNumberOfSwitches(getNumber)
    }
}