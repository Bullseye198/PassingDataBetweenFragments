package com.example.passingdatabetweenfragments.core.injection

import android.content.Context
import com.example.data.injection.DataModule
import com.example.passingdatabetweenfragments.MyApplication
import com.example.passingdatabetweenfragments.core.injection.module.ApplicationModule
import com.example.passingdatabetweenfragments.core.injection.module.ApplicationModuleBinds
import com.example.passingdatabetweenfragments.dependencyInjection.AppDataModule
import com.example.passingdatabetweenfragments.dependencyInjection.UIModule
import com.example.passingdatabetweenfragments.dependencyInjection.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    ApplicationModuleBinds::class,
    ViewModelModule::class,
    AndroidInjectionModule::class,
    UIModule::class,
    ApplicationModule::class,
    AppDataModule::class,
    DataModule::class
    ]
)

interface AppComponent : AndroidInjector<MyApplication>{
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}