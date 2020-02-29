package com.zhuzichu.android.shared.databinding.imageview

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.zhuzichu.android.shared.R
import com.zhuzichu.android.shared.global.GlideApp
import com.zhuzichu.android.widget.sharp.Sharp

@BindingAdapter(value = ["url", "fadeDuration", "error"], requireAll = false)
fun bindImageViewByUrl(
    imageView: ImageView,
    url: Any?,
    fadeDuration: Int,
    @DrawableRes error: Int
) {
    url?.apply {
        GlideApp.with(imageView)
            .load(this).also {
                if (fadeDuration != 0) {
                    it.transition(DrawableTransitionOptions.withCrossFade(fadeDuration))
                }
            }
            .placeholder(R.drawable.ic_place_holder)
            .error(error)
            .into(imageView)
    }
}

@BindingAdapter(value = ["svgData"], requireAll = false)
fun bindImageViewShap(
    imageView: ImageView,
    svgData: String?
) {
    svgData?.let {
        Sharp.loadString(it).into(imageView)
    }
}

@BindingAdapter(value = ["srcColor"], requireAll = false)
fun bindImageViewSrcColor(
    imageView: ImageView,
    @ColorInt color: Int?
) {
    color?.let {
        imageView.setColorFilter(it)
    }
}

@BindingAdapter(value = ["srcBitmap"], requireAll = false)
fun bindImageViewSrcBitmap(
    imageView: ImageView,
    bitmap: Bitmap?
) {
    bitmap?.let {
        imageView.setImageBitmap(it)
    }
}

@BindingAdapter(value = ["srcDrawable"], requireAll = false)
fun bindImageViewSrcDrawable(
    imageView: ImageView,
    drawable: Drawable?
) {
    drawable?.let {
        imageView.setImageDrawable(it)
    }
}