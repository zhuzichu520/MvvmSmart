package com.zhuzichu.android.mvvmsimple.di

import android.content.Context
import com.zhuzichu.android.mvvmsimple.ApplicationSimple
import com.zhuzichu.android.widget.notify.NotifyManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: ApplicationSimple): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun providesNotifyManager(context: Context): NotifyManager = NotifyManager(context)

}