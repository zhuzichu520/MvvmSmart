package com.zhuzichu.android.mvvmsimple.ui.home.module

import androidx.lifecycle.ViewModel
import com.zhuzichu.android.mvvm.di.ChildFragmentScoped
import com.zhuzichu.android.mvvm.di.ViewModelKey
import com.zhuzichu.android.mvvmsimple.ui.home.fragment.FragmentHome
import com.zhuzichu.android.mvvmsimple.ui.home.viewmodel.ViewModelHome
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ModuleHome {

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun fragment(): FragmentHome

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelHome::class)
    abstract fun viewModel(viewModel: ViewModelHome): ViewModel

}