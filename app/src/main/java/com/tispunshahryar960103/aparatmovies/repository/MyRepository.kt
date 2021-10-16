package com.tispunshahryar960103.aparatmovies.repository

import com.tispunshahryar960103.aparatmovies.models.Video
import com.tispunshahryar960103.aparatmovies.webService.IService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyRepository(private val iService: IService) {


    private val dispatcher=Dispatchers.IO


    suspend fun getNewVideos():List<Video>{
        return withContext(dispatcher){
            iService.getNewVideos()
        }

    }










}