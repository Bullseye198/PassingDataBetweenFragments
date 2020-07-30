package com.example.domain.model

interface SwitchRepository {

    suspend fun setNumberOfSwitches(number: Long)

}