package com.zhuzichu.android.mvvmsimple.ui.main.fragment

import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentMainBinding
import com.zhuzichu.android.mvvmsimple.ui.category.fragment.FragmentCategory
import com.zhuzichu.android.mvvmsimple.ui.demo.fragment.FragmentDemo
import com.zhuzichu.android.mvvmsimple.ui.home.fragment.FragmentHome
import com.zhuzichu.android.mvvmsimple.ui.main.viewmodel.ViewModelMain
import com.zhuzichu.android.mvvmsimple.ui.me.fragment.FragmentMe
import com.zhuzichu.android.shared.base.DefaultIntFragmentPagerAdapter
import com.zhuzichu.android.shared.extension.setupWithViewPager
import com.zhuzichu.android.shared.extension.toast
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : BaseFragment<FragmentMainBinding, ViewModelMain, DefaultArg>() {

    private val waitTime = 2000L
    private var touchTime: Long = 0

    override fun setLayoutId(): Int = R.layout.fragment_main

    override fun bindVariableId(): Int = BR.viewModel

    override fun initView() {
        val fragments = listOf<Fragment>(
            FragmentHome(),
            FragmentCategory(),
            FragmentDemo(),
            FragmentMe()
        )

        val titles = listOf(
            R.string.home,
            R.string.category,
            R.string.demo,
            R.string.me
        )

        content.adapter = DefaultIntFragmentPagerAdapter(childFragmentManager, fragments, titles)
        bottom.setupWithViewPager(content)
        initBackListener()
    }

    private fun initBackListener() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (System.currentTimeMillis() - touchTime < waitTime) {
                //退出app并清除任务栈
                requireActivity().finish()
            } else {
                touchTime = System.currentTimeMillis()
                R.string.press_again_to_exit.toast()
            }
        }
    }

}