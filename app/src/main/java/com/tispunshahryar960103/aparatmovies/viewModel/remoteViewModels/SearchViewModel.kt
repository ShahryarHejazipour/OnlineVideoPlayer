package com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tispunshahryar960103.aparatmovies.models.Video
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel(private val repository: MyRepository):ViewModel() {


    private lateinit var job: Job

    var mutableLiveData = MutableLiveData<List<Video>>()
    var mutableError = MutableLiveData<String>()
    var mutableQuery=MutableLiveData<String>()


    fun search(querySearch:String?) {

        job = viewModelScope.launch {

            try {

                val search = repository.search(querySearch)
                mutableLiveData.value = search
                mutableQuery.value=querySearch!!
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