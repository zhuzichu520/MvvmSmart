package com.zhuzichu.android.mvvmsimple.ui.demo.module

import androidx.lifecycle.ViewModel
import com.zhuzichu.android.mvvm.di.ChildFragmentScoped
import com.zhuzichu.android.mvvm.di.ViewModelKey
import com.zhuzichu.android.mvvmsimple.ui.demo.fragment.FragmentDemo
import com.zhuzichu.android.mvvmsimple.ui.demo.viewmodel.ViewModelDemo
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ModuleDemo {

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun fragment(): FragmentDemo

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelDemo::class)
    abstract fun viewModel(viewModel: ViewModelDemo): ViewModel

}