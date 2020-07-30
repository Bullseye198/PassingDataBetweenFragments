package com.example.data.injection

import com.example.data.switch.SwitchRepoImpl
import com.example.domain.model.SwitchRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindSwitchRepository(switchRepoImpl: SwitchRepoImpl): SwitchRepository
}