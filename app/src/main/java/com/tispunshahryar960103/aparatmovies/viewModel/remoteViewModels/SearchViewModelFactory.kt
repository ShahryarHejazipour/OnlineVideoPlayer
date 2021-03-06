package com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import java.lang.IllegalArgumentException

class SearchViewModelFactory(private val repository: MyRepository):ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                if (modelClass.isAssignableFrom(SearchViewModel::class.java)){
                    return SearchViewModel(repository) as T
                }

        throw IllegalArgumentException("Unknown View Model class")
    }
}