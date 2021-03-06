package com.zhuzichu.android.mvvmsimple.ui.detail.module

import androidx.lifecycle.ViewModel
import com.zhuzichu.android.mvvm.di.DialogFragmentScoped
import com.zhuzichu.android.mvvm.di.FragmentScoped
import com.zhuzichu.android.mvvm.di.ViewModelKey
import com.zhuzichu.android.mvvmsimple.ui.detail.dialog.DialogBottomFragmentDetail
import com.zhuzichu.android.mvvmsimple.ui.detail.dialog.DialogFragmentDetail
import com.zhuzichu.android.mvvmsimple.ui.detail.fragment.FragmentDetail
import com.zhuzichu.android.mvvmsimple.ui.detail.viewmodel.ViewModelDetail
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ModuleDetail {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun fragment(): FragmentDetail

    @DialogFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun dialogFragment(): DialogFragmentDetail

    @DialogFragmentScoped
    @ContributesAndroidInjector
    internal abstract fun dialogBottomFragment(): DialogBottomFragmentDetail

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelDetail::class)
    abstract fun viewModel(viewModel: ViewModelDetail): ViewModel

}