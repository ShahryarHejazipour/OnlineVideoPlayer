package com.tispunshahryar960103.aparatmovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.databinding.RowVideosBinding
import com.tispunshahryar960103.aparatmovies.models.Video

class VideosAdapter(val videoList:List<Video>): RecyclerView.Adapter<VideosAdapter.VideoVH>() {


    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoVH {

        val binding:RowVideosBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.row_videos,parent,false)

        return VideoVH(binding)


    }

    override fun onBindViewHolder(holder: VideoVH, position: Int) {

        val video=videoList[position]
        holder.binding.video=video


    }

    override fun getItemCount(): Int {
      return  videoList.size
    }


    class VideoVH(val binding:RowVideosBinding):RecyclerView.ViewHolder(binding.root)
}