package com.example.domain.usecases

import com.example.domain.model.SwitchRepository
import javax.inject.Inject

class SetNumberOfSelectedSwitchesUseCase @Inject constructor(
    private val switchRepository: SwitchRepository
) {

    suspend fun setNumberOfSelectedSwitches(isEnabled: Boolean, id: Int) {
        return switchRepository.setNumberOfSelectedSwitches(isEnabled, id)
    }
}