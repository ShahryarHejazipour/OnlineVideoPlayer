package com.tispunshahryar960103.aparatmovies.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.adapter.VideosAdapter
import com.tispunshahryar960103.aparatmovies.databinding.FragmentCategoryVideosBinding
import com.tispunshahryar960103.aparatmovies.models.Category
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import com.tispunshahryar960103.aparatmovies.utils.Constants
import com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels.VideosCategoryViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels.VideosCategoryViewModelFactory
import com.tispunshahryar960103.aparatmovies.webService.ApiClient
import com.tispunshahryar960103.aparatmovies.webService.IService

class CategoryVideosFragment : Fragment() {

    companion object{
        init {
            System.loadLibrary(Constants.LOAD_LIBRARY.str)
        }
    }

    lateinit var binding: FragmentCategoryVideosBinding
    lateinit var iService: IService
    lateinit var repository: MyRepository

    private lateinit var videosCategoryViewModel: VideosCategoryViewModel
    private lateinit var factory: VideosCategoryViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCategoryVideosBinding.inflate(inflater, container, false)




        iService=ApiClient.getClient()
        repository= MyRepository(iService)
        factory= VideosCategoryViewModelFactory(repository)
        videosCategoryViewModel=ViewModelProvider(requireActivity(),factory).get(
            VideosCategoryViewModel::class.java)


        binding.imgBack.setOnClickListener(View.OnClickListener {

          Navigation.findNavController(it).navigate(R.id.action_categoryVideosFragment_to_categoryFragment)

        })


        //getting the clicked object in CategoryAdapter that had sent with bundle and jetPack navigation component
        val category: Category? =arguments?.getParcelable("category")

        //for using dataBinding to set values into the XML layout of this fragment
        binding.category=category

        if (category != null) {
            videosCategoryViewModel.getVideosCategory(category.id.toInt(),0,10)

        }

        binding.progressCategory.visibility=View.VISIBLE
        videosCategoryViewModel.mutableLiveData.observe(requireActivity(), Observer {
            binding.progressCategory.visibility=View.GONE
         //   binding.recyclerCategory.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
            binding.recyclerCategory.layoutManager=GridLayoutManager(requireActivity(),2)
            binding.recyclerCategory.adapter=VideosAdapter(it)

        })

        videosCategoryViewModel.mutableError.observe(requireActivity(), Observer {
            binding.progressCategory.visibility=View.GONE
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()


        })


        return binding.root
    }










}