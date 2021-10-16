package com.tispunshahryar960103.aparatmovies.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import java.lang.IllegalArgumentException

class VideosCategoryViewModelFactory(private val repository: MyRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideosCategoryViewModel::class.java))
            return VideosCategoryViewModel(repository) as T
        throw IllegalArgumentException("Unknown View Model class")
    }
}