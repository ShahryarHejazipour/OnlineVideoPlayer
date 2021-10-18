package com.tispunshahryar960103.aparatmovies.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.databinding.RowVideosBinding
import com.tispunshahryar960103.aparatmovies.databinding.RowVideosVoBinding
import com.tispunshahryar960103.aparatmovies.models.Video
import com.tispunshahryar960103.aparatmovies.models.VideoVO
import com.tispunshahryar960103.aparatmovies.utils.Constants

class VideosVOAdapter(private val videoList:List<VideoVO>): RecyclerView.Adapter<VideosVOAdapter.VideoVH>() {


    companion object{
        init {
            System.loadLibrary(Constants.LOAD_LIBRARY.str)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoVH {

        val binding:RowVideosVoBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.row_videos_vo,parent,false)

        return VideoVH(binding)


    }

    override fun onBindViewHolder(holder: VideoVH, position: Int) {

        val video=videoList[position]
        holder.binding.video=video
        holder.binding.cardRowVideo.setOnClickListener(View.OnClickListener {

            val bundle=Bundle()
            bundle.putParcelable(videoKeyForBundleVO(),video)
            Navigation.findNavController(it).navigate(R.id.playerFragment,bundle)

        })


    }

    override fun getItemCount(): Int {
      return  videoList.size
    }

    private external fun videoKeyForBundleVO():String


    class VideoVH(val binding:RowVideosVoBinding):RecyclerView.ViewHolder(binding.root)
}