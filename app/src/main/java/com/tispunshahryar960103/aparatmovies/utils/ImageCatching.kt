package com.tispunshahryar960103.aparatmovies.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.tispunshahryar960103.aparatmovies.R

object ImageCatching {


    @BindingAdapter("bind:imageCatching")
    @JvmStatic
    fun imageCatching(imageView: ImageView,url:String){

        Picasso.get().load(url)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_error_24)
            .into(imageView)


    }


}