package com.zhuzichu.android.shared.ext

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.core.view.forEachIndexed
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient
import com.just.agentweb.WebChromeClient
import com.just.agentweb.WebViewClient
import com.zhuzichu.android.libs.tool.showKeyboard
import com.zhuzichu.android.shared.R
import com.zhuzichu.android.shared.global.AppGlobal.context
import com.zhuzichu.android.widget.toast.toast

fun BottomNavigationView.setupWithViewPager(viewPager: ViewPager) {
    viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            this@setupWithViewPager.menu.getItem(position).isChecked = true
        }
    })
    this.setOnNavigationItemSelectedListener {
        this@setupWithViewPager.menu.forEachIndexed { index, item ->
            if (it.itemId == item.itemId) {
                viewPager.setCurrentItem(index, false)
            }
        }
        true
    }
}

fun View.showSoftKeyboard() {
    showKeyboard(this.context, this)
}

fun Context.isDark(): Boolean {
    val mode = this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return mode == Configuration.UI_MODE_NIGHT_YES
}

fun String.toast(): Toast {
    return toast(context, this)
}

fun Int.toast(): Toast {
    return toast(context, this)
}

fun String?.getAgentWeb(
    activity: Activity,
    webContent: ViewGroup,
    layoutParams: ViewGroup.LayoutParams,
    webView: WebView,
    webViewClient: WebViewClient?,
    webChromeClient: WebChromeClient?,
    indicatorColor: Int
): AgentWeb = AgentWeb.with(activity)//传入Activity or Fragment
    .setAgentWebParent(webContent, 0, layoutParams)//传入AgentWeb 的父控件
    .useDefaultIndicator(indicatorColor, 2)// 使用默认进度条
    .setWebView(webView)
    .setWebViewClient(webViewClient)
    .setWebChromeClient(webChromeClient)
    .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
    .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
    .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
    .interceptUnkownUrl()
    .createAgentWeb()//
    .ready()
    .go(this)
