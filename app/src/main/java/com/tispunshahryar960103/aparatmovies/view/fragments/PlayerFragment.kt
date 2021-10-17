package com.tispunshahryar960103.aparatmovies.view.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.Extractor
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MediaSourceFactory
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.databinding.FragmentPlayerBinding
import com.tispunshahryar960103.aparatmovies.models.Video
import com.tispunshahryar960103.aparatmovies.utils.Constants


class PlayerFragment : Fragment() {

    companion object{
        init {
            System.loadLibrary(Constants.LOAD_LIBRARY.str)
        }
    }

    lateinit var binding:FragmentPlayerBinding
    lateinit var video:Video
    lateinit var player:SimpleExoPlayer


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPlayerBinding.inflate(inflater,container,false)

        video= arguments?.getParcelable(videoKeyForBundle())!!
        binding.video=video
        binding.imgBack.setOnClickListener(View.OnClickListener {
            requireActivity().finish()
        })

        player=SimpleExoPlayer.Builder(requireActivity()).build()

        val uri=Uri.parse(video.link)

        val mediaItem=MediaItem.fromUri(uri)

        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
        player.playWhenReady=true
        binding.exoPlayer.player=player







        return binding.root
    }

    override fun onStop() {
        super.onStop()
        if (player!=null){
            player.stop()
        }
    }

    private external fun videoKeyForBundle():String


}