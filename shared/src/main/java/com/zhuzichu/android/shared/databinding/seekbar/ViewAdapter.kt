package com.zhuzichu.android.shared.databinding.seekbar

import android.widget.SeekBar
import androidx.databinding.BindingAdapter
import com.jakewharton.rxbinding3.widget.changes
import com.zhuzichu.android.mvvm.databinding.BindingCommand

@BindingAdapter(value = ["onSeekCommand"], requireAll = false)
fun bindSeekBar(seekBar: SeekBar, onSeekCommand: BindingCommand<Int>?) {
    onSeekCommand?.apply {
        seekBar.changes().subscribe {
            execute(it)
        }
    }
}