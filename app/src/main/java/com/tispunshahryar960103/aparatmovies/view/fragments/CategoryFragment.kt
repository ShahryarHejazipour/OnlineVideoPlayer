package com.tispunshahryar960103.aparatmovies.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.adapter.CategoryAdapter
import com.tispunshahryar960103.aparatmovies.databinding.FragmentCategoryBinding
import com.tispunshahryar960103.aparatmovies.databinding.FragmentHomeBinding
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import com.tispunshahryar960103.aparatmovies.viewModel.CategoryViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.CategoryViewModelFactory
import com.tispunshahryar960103.aparatmovies.webService.ApiClient
import com.tispunshahryar960103.aparatmovies.webService.IService


class CategoryFragment : Fragment() {

    lateinit var binding:FragmentCategoryBinding
    lateinit var iService: IService
    lateinit var repository: MyRepository

    lateinit var categoryViewModel: CategoryViewModel
    lateinit var categoryViewModelFactory: CategoryViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCategoryBinding.inflate(inflater,container,false)


        iService = ApiClient.getClient()
        repository = MyRepository(iService)
        categoryViewModelFactory= CategoryViewModelFactory(repository)
        categoryViewModel=ViewModelProvider(requireActivity(),categoryViewModelFactory).get(CategoryViewModel::class.java)
        categoryViewModel.getCategories()

        binding.progressCategory.visibility=View.VISIBLE
        categoryViewModel.mutableLiveData.observe(requireActivity(), Observer {

            binding.progressCategory.visibility=View.GONE
           binding.recyclerCategory.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
            binding.recyclerCategory.adapter=CategoryAdapter(it)

        })











        return binding.root
    }


}