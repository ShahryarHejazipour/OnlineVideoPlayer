package com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tispunshahryar960103.aparatmovies.models.Category
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class CategoryViewModel(private val repository: MyRepository):ViewModel() {


    lateinit var job: Job

    var mutableLiveData = MutableLiveData<List<Category>>()
    var mutableError = MutableLiveData<String>()


    fun getCategories() {

        job = viewModelScope.launch {

            try {

                val categoryList = repository.getCategories()
                mutableLiveData.value = categoryList
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