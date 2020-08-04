package com.example.domain.model

interface SwitchRepository {

    suspend fun setNumberOfSwitches(number: Long): Long?

    suspend fun getNumberOfSwitches(getNumber: Long): Long?

}