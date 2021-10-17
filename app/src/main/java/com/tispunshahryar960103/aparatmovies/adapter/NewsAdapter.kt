package com.tispunshahryar960103.aparatmovies.adapter

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.databinding.NewsLayoutBinding
import com.tispunshahryar960103.aparatmovies.models.News

class NewsAdapter(val context:Context, private val newsList: List<News>) : PagerAdapter() {

   lateinit var binding: NewsLayoutBinding


    override fun getCount(): Int {
        return newsList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

      binding=DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.news_layout,container ,false)
     //   val binding = NewsLayoutBinding.inflate(LayoutInflater.from(context), container, false)

        val news=newsList[position]
        binding.news=news

       container.addView(binding.root)

        return binding.root
    }

    override fun saveState(): Parcelable? {
        return super.saveState()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView((`object` as View?))
       // container.removeView(`object` as LinearLayout)
    }
}