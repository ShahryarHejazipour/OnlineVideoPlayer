package com.tispunshahryar960103.aparatmovies.webService

import com.tispunshahryar960103.aparatmovies.models.Category
import com.tispunshahryar960103.aparatmovies.models.News
import com.tispunshahryar960103.aparatmovies.models.Video
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IService {


    @GET("getNewVideos.php")
    suspend fun getNewVideos(): List<Video>

    @GET("getSpecial.php")
    suspend fun getSpecialVideos():List<Video>

    @GET("getBestVideos.php")
    suspend fun getBestVideos():List<Video>

    @GET("getCategory.php")
    suspend fun getCategories():List<Category>

    @POST("getVideosCategory.php")
    @FormUrlEncoded
    suspend fun getVideosCategory(@Field("catId") id:Int,@Field("from") from:Int,@Field("to") to:Int):List<Video>


    @GET("getNews.php")
    suspend fun getNews():List<News>




}