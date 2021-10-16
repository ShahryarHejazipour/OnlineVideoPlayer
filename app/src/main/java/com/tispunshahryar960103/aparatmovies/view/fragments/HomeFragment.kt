package com.tispunshahryar960103.aparatmovies.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.aparatmovies.adapter.VideosAdapter
import com.tispunshahryar960103.aparatmovies.databinding.FragmentHomeBinding
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import com.tispunshahryar960103.aparatmovies.viewModel.NewVideosViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.NewVideosViewModelFactory
import com.tispunshahryar960103.aparatmovies.webService.ApiClient
import com.tispunshahryar960103.aparatmovies.webService.IService


class HomeFragment() : Fragment() {

    lateinit var binding: FragmentHomeBinding

    lateinit var viewModel: NewVideosViewModel
    lateinit var factory: NewVideosViewModelFactory
    lateinit var repository: MyRepository
    lateinit var iService: IService


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        iService = ApiClient.getClient()
        repository = MyRepository(iService)
        factory = NewVideosViewModelFactory(repository)
        viewModel =
            ViewModelProvider(requireActivity(), factory).get(NewVideosViewModel::class.java)

        binding.progressNewVideos.visibility = View.VISIBLE
        viewModel.getNewVideos()
        viewModel.mutableLiveData.observe(requireActivity(), Observer {

            binding.progressNewVideos.visibility = View.GONE
            binding.recyclerNewVideos.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.HORIZONTAL,false)
            binding.recyclerNewVideos.adapter=VideosAdapter(it)


            Log.e("", "")


        })

        viewModel.mutableError.observe(requireActivity(), Observer {
            binding.progressNewVideos.visibility = View.GONE
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
        })









        return binding.root
    }


}