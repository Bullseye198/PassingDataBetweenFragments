package com.example.domain.model

interface SwitchRepository {

    suspend fun setNumberOfSwitches(number: Long)

    suspend fun getNumberOfSwitches(): Long

    suspend fun getNumberOfSelectedSwitches(): Int

    suspend fun increaseNumberOfSwitches()

    suspend fun decreaseNumberOfSwitches()
}