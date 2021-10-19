package com.tispunshahryar960103.aparatmovies.view.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
import com.tispunshahryar960103.aparatmovies.models.VideoVO
import com.tispunshahryar960103.aparatmovies.orm.AppDatabase
import com.tispunshahryar960103.aparatmovies.orm.VideoDAO
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import com.tispunshahryar960103.aparatmovies.repository.RoomRepository
import com.tispunshahryar960103.aparatmovies.utils.Constants
import com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels.CreatorViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels.CreatorViewModelFactory
import com.tispunshahryar960103.aparatmovies.viewModel.roomViewModels.InsertViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.roomViewModels.InsertViewModelFactory
import com.tispunshahryar960103.aparatmovies.webService.ApiClient
import com.tispunshahryar960103.aparatmovies.webService.IService


class PlayerFragment : Fragment() {

    companion object{
        init {
            System.loadLibrary(Constants.LOAD_LIBRARY.str)
        }
    }

    lateinit var binding:FragmentPlayerBinding
    lateinit var video:Video
    lateinit var player:SimpleExoPlayer
    lateinit var videoDAO: VideoDAO
    lateinit var iService: IService
    lateinit var repository: MyRepository

    lateinit var insertViewModel: InsertViewModel
    lateinit var insertViewModelFactory: InsertViewModelFactory
    lateinit var roomRepository: RoomRepository
    lateinit var creatorViewModelFactory:CreatorViewModelFactory
    lateinit var creatorViewModel: CreatorViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPlayerBinding.inflate(inflater,container,false)




        video= arguments?.getParcelable(videoKeyForBundle())!!
        video= arguments?.getParcelable(videoKeyForBundleVO())!!
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


        /*
        for setting up the bookmark videos and saving them in Room
         */

        videoDAO=AppDatabase.getInstance(requireActivity()).getVideoDAO()
        roomRepository= RoomRepository(videoDAO)
        insertViewModelFactory= InsertViewModelFactory(roomRepository)
        insertViewModel=ViewModelProvider(requireActivity(),insertViewModelFactory).get(InsertViewModel::class.java)


        binding.imgBookmark.setOnClickListener(View.OnClickListener {

            val videoVO=VideoVO(video.id.toInt(),video.cat_id.toInt(),video.creator.toInt(),video.description
                ,video.icon,video.link,video.special.toInt(),video.time,video.title,video.view.toInt())
            insertViewModel.insertVideo(videoVO)
            insertViewModel.mutableLiveData.observe(requireActivity(), Observer {

                if (it>0){
                    Toast.makeText(requireActivity(), "ویدیو به علاقه مندی ها افزوده شد..", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(requireActivity(), "خطا در افزودن ویدیو", Toast.LENGTH_SHORT).show()

                }


            })





        })


        iService=ApiClient.getClient()
        repository= MyRepository(iService)
        creatorViewModelFactory=CreatorViewModelFactory(repository)
        creatorViewModel=ViewModelProvider(requireActivity(),creatorViewModelFactory).get(CreatorViewModel::class.java)
        creatorViewModel.getCreator(video.creator.toInt())
        creatorViewModel.mutableLiveData.observe(requireActivity(), Observer {


            binding.creator=it

        })





        return binding.root
    }

    override fun onStop() {
        super.onStop()
        if (player!=null){
            player.stop()
        }
    }

    private external fun videoKeyForBundle():String
    private external fun videoKeyForBundleVO():String


}