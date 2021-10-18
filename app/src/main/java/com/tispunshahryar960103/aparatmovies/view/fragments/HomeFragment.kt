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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.tispunshahryar960103.aparatmovies.adapter.NewsAdapter
import com.tispunshahryar960103.aparatmovies.adapter.VideosAdapter
import com.tispunshahryar960103.aparatmovies.databinding.FragmentHomeBinding
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import com.tispunshahryar960103.aparatmovies.utils.AppConfig
import com.tispunshahryar960103.aparatmovies.viewModel.*
import com.tispunshahryar960103.aparatmovies.webService.ApiClient
import com.tispunshahryar960103.aparatmovies.webService.IService
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment() : Fragment()/*,ViewPager.OnPageChangeListener*/ {

    lateinit var binding: FragmentHomeBinding
    lateinit var iService: IService
    lateinit var repository: MyRepository


    lateinit var newVideosViewModel: NewVideosViewModel
    lateinit var newVideosViewModelFactory: NewVideosViewModelFactory

    lateinit var specialVideosViewModel:SpecialVideosViewModel
    lateinit var specialVideosViewModelFactory: SpecialVideosViewModelFactory

    lateinit var bestVideosViewModel: BestVideosViewModel
    lateinit var bestVideosViewModelFactory: BestVideosViewModelFactory

    lateinit var newsViewModel: NewsViewModel
    lateinit var newsViewModelFactory: NewsViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        iService = ApiClient.getClient()
        repository = MyRepository(iService)


        //Implementing newVideos webService
        newVideosViewModelFactory = NewVideosViewModelFactory(repository)
        newVideosViewModel =
            ViewModelProvider(requireActivity(), newVideosViewModelFactory).get(NewVideosViewModel::class.java)

        binding.progressNewVideos.visibility = View.VISIBLE
        newVideosViewModel.getNewVideos()
        newVideosViewModel.mutableLiveData.observe(requireActivity(), Observer {

            binding.progressNewVideos.visibility = View.GONE
            binding.recyclerNewVideos.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.HORIZONTAL,false)
            binding.recyclerNewVideos.adapter=VideosAdapter(it)


            Log.e("", "")


        })

        newVideosViewModel.mutableError.observe(requireActivity(), Observer {
            binding.progressNewVideos.visibility = View.GONE
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
        })




        //Implementing SpecialVideos webService
        binding.progressSpecialVideos.visibility=View.VISIBLE
        specialVideosViewModelFactory= SpecialVideosViewModelFactory(repository)
        specialVideosViewModel=ViewModelProvider(requireActivity(),specialVideosViewModelFactory).get(SpecialVideosViewModel::class.java)
        specialVideosViewModel.getSpecialVideos()
        specialVideosViewModel.mutableLiveData.observe(requireActivity(), Observer {

            binding.progressSpecialVideos.visibility=View.GONE
            binding.recyclerSpecialVideos.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.HORIZONTAL,false)
            binding.recyclerSpecialVideos.adapter=VideosAdapter(it)

        })


        specialVideosViewModel.mutableError.observe(requireActivity(), Observer {

            binding.progressSpecialVideos.visibility = View.GONE
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()

        })


        //Implementing BestVideos webService
        binding.progressBestVideos.visibility=View.VISIBLE
        bestVideosViewModelFactory= BestVideosViewModelFactory(repository)
        bestVideosViewModel=ViewModelProvider(requireActivity(),bestVideosViewModelFactory).get(BestVideosViewModel::class.java)
        bestVideosViewModel.getBestVideos()
        bestVideosViewModel.mutableLiveData.observe(requireActivity(), Observer {
            binding.progressBestVideos.visibility=View.GONE
           // binding.recyclerBestVideos.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.HORIZONTAL,false)
            binding.recyclerBestVideos.layoutManager=GridLayoutManager(requireActivity(),2)
            binding.recyclerBestVideos.adapter=VideosAdapter(it)

        })

        bestVideosViewModel.mutableError.observe(requireActivity(), Observer {
            binding.progressBestVideos.visibility=View.GONE
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
        })



        //Implementing News webService

        newsViewModelFactory= NewsViewModelFactory(repository)
        newsViewModel=ViewModelProvider(requireActivity(),newsViewModelFactory).get(NewsViewModel::class.java)

        newsViewModel.getNews()
        newsViewModel.mutableLiveData.observe(requireActivity(), Observer {

            binding.pager.adapter=NewsAdapter(requireActivity(),it)

        })

        newsViewModel.mutableError.observe(requireActivity(), Observer {

            Log.e("", "" )
        })


        //setting up the View Pager Indicator
       // binding.pager.addOnPageChangeListener(this)


        return binding.root
    }

/*    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        TODO("Not yet implemented")
    }

    override fun onPageSelected(position: Int) {
        pageIndicatorView.selection = position;
    }

    override fun onPageScrollStateChanged(state: Int) {
        TODO("Not yet implemented")
    }*/


}