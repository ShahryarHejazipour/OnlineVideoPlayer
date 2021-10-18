package com.tispunshahryar960103.aparatmovies.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.adapter.VideosAdapter
import com.tispunshahryar960103.aparatmovies.adapter.VideosVOAdapter
import com.tispunshahryar960103.aparatmovies.databinding.FragmentFavoriteBinding
import com.tispunshahryar960103.aparatmovies.models.Video
import com.tispunshahryar960103.aparatmovies.models.VideoVO
import com.tispunshahryar960103.aparatmovies.orm.AppDatabase
import com.tispunshahryar960103.aparatmovies.orm.VideoDAO
import com.tispunshahryar960103.aparatmovies.repository.RoomRepository
import com.tispunshahryar960103.aparatmovies.viewModel.roomViewModels.FavoriteViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.roomViewModels.FavoriteViewModelFactory
import com.tispunshahryar960103.aparatmovies.viewModel.roomViewModels.InsertViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.roomViewModels.InsertViewModelFactory


class FavoriteFragment : Fragment() {

    lateinit var binding: FragmentFavoriteBinding

    private lateinit var videoDAO: VideoDAO
    lateinit var roomRepository: RoomRepository
    lateinit var favoriteViewModelFactory: FavoriteViewModelFactory
    lateinit var favoriteViewModel: FavoriteViewModel
    lateinit var video: Video


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        videoDAO = AppDatabase.getInstance(requireActivity()).getVideoDAO()
        roomRepository = RoomRepository(videoDAO)
        favoriteViewModelFactory = FavoriteViewModelFactory(roomRepository)
        favoriteViewModel = ViewModelProvider(
            requireActivity(),
            favoriteViewModelFactory
        ).get(FavoriteViewModel::class.java)

        favoriteViewModel.getAllVideos()
        favoriteViewModel.mutableLiveData.observe(requireActivity(), Observer {



            binding.recyclerFavorite.adapter=VideosVOAdapter(it)
            binding.recyclerFavorite.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)

        })


        return binding.root
    }


}