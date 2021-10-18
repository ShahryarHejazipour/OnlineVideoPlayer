package com.tispunshahryar960103.aparatmovies.viewModel.roomViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.aparatmovies.repository.RoomRepository
import java.lang.IllegalArgumentException

class InsertViewModelFactory(private val roomRepository: RoomRepository):ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(InsertViewModel::class.java)){
            return InsertViewModel(roomRepository) as T
        }
        throw IllegalArgumentException ("Unknown View Model class")

    }
}