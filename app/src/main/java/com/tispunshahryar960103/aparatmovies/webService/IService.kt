package com.tispunshahryar960103.aparatmovies.webService

import androidx.annotation.Nullable
import com.tispunshahryar960103.aparatmovies.models.Video
import com.tispunshahryar960103.aparatmovies.utils.Constants
import retrofit2.http.GET

interface IService {




    @GET("getNewVideos.php")
    suspend fun getNewVideos(): List<Video>





}