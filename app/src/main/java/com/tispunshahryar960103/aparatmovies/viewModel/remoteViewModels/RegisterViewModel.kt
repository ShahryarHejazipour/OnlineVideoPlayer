package com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import java.lang.Exception

class RegisterViewModel(private val repository: MyRepository):ViewModel() {


    private lateinit var job: Job

    var mutableLiveData = MutableLiveData<ResponseBody>()
    var mutableError = MutableLiveData<String>()



    fun register(username:String,password:String) {

        job = viewModelScope.launch {

            try {

                val responseBody = repository.register(username,password)
                mutableLiveData.value = responseBody
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