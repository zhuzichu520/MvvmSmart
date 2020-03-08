package com.zhuzichu.android.mvvmsimple.ui.demo.fresco.module

import androidx.lifecycle.ViewModel
import com.zhuzichu.android.mvvm.di.ChildFragmentScoped
import com.zhuzichu.android.mvvm.di.ViewModelKey
import com.zhuzichu.android.mvvmsimple.ui.demo.fresco.fragment.FragmentFresco
import com.zhuzichu.android.mvvmsimple.ui.demo.fresco.viewmodel.ViewModelFresco
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ModuleFresco {

    @ChildFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun fragment(): FragmentFresco

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelFresco::class)
    abstract fun viewModel(viewModel: ViewModelFresco): ViewModel

}