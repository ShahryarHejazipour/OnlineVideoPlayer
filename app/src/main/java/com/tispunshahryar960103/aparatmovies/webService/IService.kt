package com.tispunshahryar960103.aparatmovies.webService

import com.tispunshahryar960103.aparatmovies.models.Video
import retrofit2.http.GET

interface IService {


    @GET("getNewVideos.php")
    suspend fun getNewVideos(): List<Video>

    @GET("getSpecial.php")
    suspend fun getSpecialVideos():List<Video>

    @GET("getBestVideos.php")
    suspend fun getBestVideos():List<Video>






}