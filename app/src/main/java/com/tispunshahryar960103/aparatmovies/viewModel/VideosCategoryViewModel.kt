package com.tispunshahryar960103.aparatmovies.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tispunshahryar960103.aparatmovies.models.Category
import com.tispunshahryar960103.aparatmovies.models.Video
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class VideosCategoryViewModel(private val repository: MyRepository):ViewModel() {


    lateinit var job: Job

    var mutableLiveData = MutableLiveData<List<Video>>()
    var mutableError = MutableLiveData<String>()


    fun getVideosCategory(id:Int,from:Int,to:Int) {

        job = viewModelScope.launch {

            try {

                val videoCategoryList = repository.getVideosCategory(id,from,to)
                mutableLiveData.value = videoCategoryList
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