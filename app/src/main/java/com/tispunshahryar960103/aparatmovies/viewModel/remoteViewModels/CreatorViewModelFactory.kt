package com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import java.lang.IllegalArgumentException

class CreatorViewModelFactory(private val repository: MyRepository):ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CreatorViewModel::class.java)){
            return CreatorViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown View Model class")

    }
}