package com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tispunshahryar960103.aparatmovies.models.News
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(private val repository: MyRepository):ViewModel() {



    lateinit var job: Job

    var mutableLiveData = MutableLiveData<List<News>>()
    var mutableError = MutableLiveData<String>()


    fun getNews() {

        job = viewModelScope.launch {

            try {

                val newsList = repository.getNews()
                mutableLiveData.value = newsList
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