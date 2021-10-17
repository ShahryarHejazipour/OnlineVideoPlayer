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
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.adapter.VideosAdapter
import com.tispunshahryar960103.aparatmovies.databinding.FragmentSearchBinding
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import com.tispunshahryar960103.aparatmovies.viewModel.SearchViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.SearchViewModelFactory
import com.tispunshahryar960103.aparatmovies.webService.ApiClient
import com.tispunshahryar960103.aparatmovies.webService.IService

class SearchFragment : Fragment() {

    lateinit var binding:FragmentSearchBinding
    lateinit var iService: IService
    lateinit var repository: MyRepository



    lateinit var searchViewModel: SearchViewModel
    lateinit var searchViewModelFactory: SearchViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSearchBinding.inflate(inflater,container,false)

        iService = ApiClient.getClient()
        repository = MyRepository(iService)

        binding.imgBack.setOnClickListener(View.OnClickListener {

            Navigation.findNavController(it).navigate(R.id.homeFragment)

        })


        val searchQuery: String? =arguments?.getString("search","")

        searchViewModelFactory= SearchViewModelFactory(repository)
        searchViewModel=ViewModelProvider(requireActivity(),searchViewModelFactory).get(SearchViewModel::class.java)
        if (searchQuery != null) {


            searchViewModel.search(searchQuery)

            binding.progressSearch.visibility=View.VISIBLE
            searchViewModel.mutableLiveData.observe(requireActivity(), Observer {
                binding.progressSearch.visibility=View.GONE
              /*  val video=it[0]
                binding.video=video*/
                binding.recyclerSearch.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
                binding.recyclerSearch.adapter=VideosAdapter(it)
                Log.e("", "" )


            })
        }
        searchViewModel.mutableQuery.observe(requireActivity(), Observer {

            binding.txtTitle.text=it



        })


        searchViewModel.mutableError.observe(requireActivity(), Observer {
            binding.progressSearch.visibility=View.GONE
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()


        })



















        return binding.root
    }


}