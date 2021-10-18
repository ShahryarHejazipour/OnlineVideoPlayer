package com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import java.lang.IllegalArgumentException

class BestVideosViewModelFactory(private val repository: MyRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {


        if (modelClass.isAssignableFrom(BestVideosViewModel::class.java))
            return BestVideosViewModel(repository) as T

        throw IllegalArgumentException("Unknown View Model class")
    }
}