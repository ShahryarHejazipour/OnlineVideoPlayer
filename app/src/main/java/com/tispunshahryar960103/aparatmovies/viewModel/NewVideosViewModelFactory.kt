package com.tispunshahryar960103.aparatmovies.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import java.lang.IllegalArgumentException

class NewVideosViewModelFactory(private val myRepository: MyRepository):ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(NewVideosViewModel::class.java))
            return NewVideosViewModel(myRepository) as T

        throw IllegalArgumentException("Unknown View Model class")
    }
}