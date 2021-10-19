package com.tispunshahryar960103.aparatmovies.repository

import com.tispunshahryar960103.aparatmovies.models.Category
import com.tispunshahryar960103.aparatmovies.models.Creator
import com.tispunshahryar960103.aparatmovies.models.News
import com.tispunshahryar960103.aparatmovies.models.Video
import com.tispunshahryar960103.aparatmovies.webService.IService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody

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

    suspend fun getNews():List<News>{
        return withContext(dispatcher){
            iService.getNews()
        }
    }

    suspend fun search(querySearch:String?):List<Video>{
        return withContext(dispatcher){
            iService.search(querySearch)
        }
    }

    suspend fun register(username:String,password:String):ResponseBody{
        return withContext(dispatcher){
            iService.register(username,password)
        }
    }
    suspend fun login(username:String,password:String):ResponseBody{
        return withContext(dispatcher){
            iService.login(username,password)
        }
    }

    suspend fun getCreator(creatorId:Int):Creator{

        return withContext(dispatcher){
            iService.getCreator(creatorId)
        }
    }










}