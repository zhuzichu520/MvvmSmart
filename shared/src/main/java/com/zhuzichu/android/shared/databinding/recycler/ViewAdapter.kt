package com.zhuzichu.android.shared.databinding.recycler

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.zhuzichu.android.mvvm.databinding.BindingCommand
import com.zhuzichu.android.shared.rxbinding.scrollBottom
import com.zhuzichu.android.shared.widget.recycler.LineManager
import com.zhuzichu.android.widget.recycler.BottomRecyclerView
import java.util.concurrent.TimeUnit

@BindingAdapter(value = ["onBottomCommand"], requireAll = false)
fun bindRecyclerView(
    recyclerView: BottomRecyclerView,
    onBottomCommand: BindingCommand<*>?
) {
    onBottomCommand?.apply {
        recyclerView.scrollBottom()
            .throttleFirst(100, TimeUnit.MILLISECONDS)
            .subscribe {
                execute()
            }
    }
}

@BindingAdapter(value = ["onRefreshCommand"], requireAll = false)
fun bindSwipeRefreshLayout(
    swipeRefreshLayout: SwipeRefreshLayout,
    onRefreshCommand: BindingCommand<SwipeRefreshLayout>?
) {
    swipeRefreshLayout.setOnRefreshListener {
        onRefreshCommand?.execute(swipeRefreshLayout)
    }
}


@BindingAdapter("lineManager")
fun setLineManager(
    recyclerView: RecyclerView,
    factory: LineManager.Factory
) {
    recyclerView.addItemDecoration(factory.create(recyclerView))
}
