package com.example.data.number

import com.example.domain.model.SwitchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SwitchRepoImpl @Inject constructor(

) : SwitchRepository {

    private var numberOfSwitches: Long = 0L
    private var selectedSwitchesEnabled: Boolean = false
    private var selectedSwitches = mutableListOf<Int>()

    override suspend fun setNumberOfSwitches(number: Long) {
        numberOfSwitches = number
    }

    override suspend fun getNumberOfSwitches(): Long {
        return numberOfSwitches
    }

    override suspend fun setNumberOfSelectedSwitches(isEnabled: Boolean, id: Int) {
        if (!selectedSwitches.contains(id) && isEnabled) {
            selectedSwitchesEnabled = isEnabled
            selectedSwitches.add(id)
        } else {
            selectedSwitchesEnabled = isEnabled
            selectedSwitches.remove(id)
        }
    }

    override suspend fun getNumberOfSelectedSwitches(): MutableList<Int> {
        return selectedSwitches
    }
}