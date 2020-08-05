package com.example.passingdatabetweenfragments.core.injection.module

import com.example.passingdatabetweenfragments.MainActivity
import com.example.passingdatabetweenfragments.dependencyInjection.UIModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ApplicationModuleBinds {

    @ContributesAndroidInjector(
        modules = [UIModule::class]
    )
    fun contributeMainActivity(): MainActivity
}