package com.tispunshahryar960103.aparatmovies.repository

import com.tispunshahryar960103.aparatmovies.models.Category
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


    suspend fun getSpecialVideos():List<Video>{
        return withContext(dispatcher){
            iService.getSpecialVideos()
        }
    }

    suspend fun getBestVideos():List<Video>{
        return withContext(dispatcher){
            iService.getBestVideos()
        }
    }

    suspend fun getCategories():List<Category>{
        return withContext(dispatcher){
            iService.getCategories()
        }
    }

    suspend fun getVideosCategory(id:Int,from:Int,to:Int):List<Video>{
        return withContext(dispatcher){
            iService.getVideosCategory(id,from,to)
        }
    }










}