package com.zhuzichu.android.mvvmsimple.ui.theme.module

import androidx.lifecycle.ViewModel
import com.zhuzichu.android.mvvm.di.FragmentScoped
import com.zhuzichu.android.mvvm.di.ViewModelKey
import com.zhuzichu.android.mvvmsimple.ui.theme.fragment.DialogFragmentChooseTheme
import com.zhuzichu.android.mvvmsimple.ui.theme.viewmodel.ViewModelTheme
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ModuleTheme {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun fragment(): DialogFragmentChooseTheme

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelTheme::class)
    abstract fun viewModel(viewModel: ViewModelTheme): ViewModel


}