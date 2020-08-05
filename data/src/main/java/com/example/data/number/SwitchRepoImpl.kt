package com.example.data.number

import com.example.domain.model.SwitchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SwitchRepoImpl @Inject constructor(

) : SwitchRepository {

    private var numberOfSwitches: Long = 0L
    private var numberOfSelectedSwitches : Int = 0

    override suspend fun setNumberOfSwitches(number: Long) {
        numberOfSwitches = number
    }

    override suspend fun getNumberOfSwitches(): Long {
        return numberOfSwitches
    }

    override suspend fun getNumberOfSelectedSwitches(): Int {
        return numberOfSelectedSwitches
    }

    override suspend fun increaseNumberOfSwitches() {
        numberOfSelectedSwitches += 1
    }

    override suspend fun decreaseNumberOfSwitches() {
        numberOfSelectedSwitches -= 1
    }
}