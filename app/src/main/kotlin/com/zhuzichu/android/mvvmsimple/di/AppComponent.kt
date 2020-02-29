package com.zhuzichu.android.mvvmsimple.di

import com.zhuzichu.android.mvvm.di.ViewModelModule
import com.zhuzichu.android.mvvmsimple.ApplicationSimple
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        AppModule::class,
        ActivityBindingModule::class
    ]
)

interface AppComponent : AndroidInjector<ApplicationSimple> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: ApplicationSimple): AppComponent
    }
}