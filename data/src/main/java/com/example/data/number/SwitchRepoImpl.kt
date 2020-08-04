package com.example.data.number

import com.example.domain.model.SwitchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SwitchRepoImpl @Inject constructor(

) : SwitchRepository {

    private var numberOfSwitches: Long? = null

    override suspend fun setNumberOfSwitches(number: Long): Long? {
        return numberOfSwitches?.plus(number)
    }

    override suspend fun getNumberOfSwitches(getNumber: Long): Long? {
        return setNumberOfSwitches(getNumber)
    }
}