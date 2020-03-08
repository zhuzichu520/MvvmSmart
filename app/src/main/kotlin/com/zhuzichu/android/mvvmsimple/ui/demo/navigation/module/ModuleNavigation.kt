package com.zhuzichu.android.mvvmsimple.ui.demo.navigation.module

import androidx.lifecycle.ViewModel
import com.zhuzichu.android.mvvm.di.ChildFragmentScoped
import com.zhuzichu.android.mvvm.di.ViewModelKey
import com.zhuzichu.android.mvvmsimple.ui.demo.navigation.fragment.FragmentNavigation
import com.zhuzichu.android.mvvmsimple.ui.demo.navigation.viewmodel.ViewModelNavigation
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ModuleNavigation {

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun fragment(): FragmentNavigation

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelNavigation::class)
    abstract fun viewModel(viewModel: ViewModelNavigation): ViewModel

}