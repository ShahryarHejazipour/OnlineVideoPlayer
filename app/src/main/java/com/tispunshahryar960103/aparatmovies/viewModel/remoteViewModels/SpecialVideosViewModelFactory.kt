package com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import java.lang.IllegalArgumentException

class SpecialVideosViewModelFactory(val repository: MyRepository):ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SpecialVideosViewModel::class.java))
            return SpecialVideosViewModel(repository) as T

        throw IllegalArgumentException("Unknown View Model class")

    }
}