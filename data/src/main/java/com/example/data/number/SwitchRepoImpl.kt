package com.example.data.number

import com.example.domain.model.SwitchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SwitchRepoImpl @Inject constructor(

) : SwitchRepository {

    lateinit var numberOfSwitches: MutableList<Long>

    override suspend fun setNumberOfSwitches(number: Long) {
        numberOfSwitches.add(number)
    }
}