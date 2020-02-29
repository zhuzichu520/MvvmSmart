package com.zhuzichu.android.mvvm.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.AnimBuilder
import androidx.navigation.findNavController
import com.zhuzichu.android.libs.internal.MainHandler
import com.zhuzichu.android.libs.tool.closeKeyboard
import com.zhuzichu.android.libs.tool.decodeBase64
import com.zhuzichu.android.libs.tool.json2Object
import com.zhuzichu.android.libs.tool.toCast
import com.zhuzichu.android.mvvm.Mvvm.KEY_ARG
import com.zhuzichu.android.mvvm.Mvvm.KEY_ARG_JSON
import com.zhuzichu.android.mvvm.Mvvm.getDefaultNavOptions
import com.zhuzichu.android.mvvm.R
import com.zhuzichu.android.widget.dialog.loading.LoadingMaker
import dagger.android.support.DaggerFragment
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseFragment<TBinding : ViewDataBinding, TViewModel : BaseViewModel<TArg>, TArg : BaseArg> :
    DaggerFragment(), IBaseView<TArg>, IBaseCommon {

    var binding: TBinding? = null
    lateinit var arg: TArg
    lateinit var viewModel: TViewModel
    lateinit var activityCtx: Activity

    val navController by lazy { activityCtx.findNavController(R.id.delegate_container) }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun setLayoutId(): Int
    abstract fun bindVariableId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            setLayoutId(),
            container,
            false
        )
        binding?.lifecycleOwner = this
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewDataBinding()
        registUIChangeLiveDataCallback()
        initVariable()
        initView()
        initListener()
        initViewObservable()
        initData()
        if (!viewModel.isInitData) {
            initFirstData()
            viewModel.isInitData = true
        }
    }

    private fun initViewDataBinding() {
        val type = this::class.java.genericSuperclass
        val modelClass = if (type is ParameterizedType) {
            type.actualTypeArguments[1]
        } else {
            BaseViewModel::class.java
        }

        val argClass = if (type is ParameterizedType) {
            type.actualTypeArguments[2]
        } else {
            DefaultArg::class.java
        }

        val argJson = arguments?.getString(KEY_ARG_JSON)
        arg = if (argJson.isNullOrEmpty()) {
            (arguments?.get(KEY_ARG) ?: DefaultArg()).toCast()
        } else {
            json2Object(decodeBase64(argJson), argClass) ?: DefaultArg().toCast()
        }
        viewModel = ViewModelProvider(this, viewModelFactory).get(modelClass.toCast())
        viewModel.arg = arg
        initArgs(arg)
        binding?.setVariable(bindVariableId(), viewModel)
        lifecycle.addObserver(viewModel)
    }

    private fun registUIChangeLiveDataCallback() {

        viewModel.uc.onStartEvent.observe(viewLifecycleOwner, Observer {
            navController.navigate(
                it.actionId,
                bundleOf(KEY_ARG to it.arg),
                getDefaultNavOptions(it.destinationId, it.inclusive, it.singleTop, it.animBuilder)
            )
        })

        viewModel.uc.onBackPressedEvent.observe(viewLifecycleOwner, Observer {
            activityCtx.onBackPressed()
        })

        viewModel.uc.onShowLoadingEvent.observe(viewLifecycleOwner, Observer {
            closeKeyboard(activityCtx)
            MainHandler.postDelayed {
                LoadingMaker.showLoadingDialog(activityCtx)
            }
        })

        viewModel.uc.onHideLoadingEvent.observe(viewLifecycleOwner, Observer {
            MainHandler.postDelayed {
                LoadingMaker.dismissLodingDialog()
            }
        })

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityCtx = requireActivity()
    }

    override fun onResume() {
        super.onResume()
        if (!viewModel.isInitLazyView) {
            initLazyView()
            viewModel.isInitLazyView = true
        }

        if (!viewModel.isInitLazy) {
            initLazyData()
            viewModel.isInitLazy = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.isInitLazyView = false
        binding?.unbind()
        binding = null
    }

    override fun back() {
        viewModel.back()
    }

    override fun showLoading() {
        viewModel.showLoading()
    }

    override fun hideLoading() {
        viewModel.hideLoading()
    }

    override fun start(
        actionId: Int,
        arg: BaseArg?,
        animBuilder: AnimBuilder?,
        destinationId: Int?,
        inclusive: Boolean?,
        singleTop: Boolean?
    ) {
        viewModel.start(actionId, arg, animBuilder, destinationId, inclusive, singleTop)
    }

    override fun initArgs(arg: TArg) {
        viewModel.initArgs(arg)
    }

    override fun initViewObservable() {
        viewModel.initViewObservable()
    }

    override fun initVariable() {
        viewModel.initVariable()
    }

    override fun initView() {
        viewModel.initView()
    }

    override fun initData() {
        viewModel.initData()
    }

    override fun initFirstData() {
        viewModel.initFirstData()
    }

    override fun initLazyData() {
        viewModel.initLazyData()
    }

    override fun initLazyView() {
        viewModel.initLazyView()
    }

    override fun initListener() {
        viewModel.initListener()
    }
}