package com.tispunshahryar960103.aparatmovies.viewModel.roomViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tispunshahryar960103.aparatmovies.models.VideoVO
import com.tispunshahryar960103.aparatmovies.repository.RoomRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class FavoriteViewModel(private val roomRepository: RoomRepository):ViewModel() {



    lateinit var job: Job

    var mutableLiveData = MutableLiveData<List<VideoVO>>()
    var mutableError = MutableLiveData<String>()


    fun getAllVideos() {

        job = viewModelScope.launch {

            try {

                val result=roomRepository.getAllVideos()
                mutableLiveData.value = result
            } catch (e: Exception) {
                mutableError.value = e.toString()
            }


        }
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}