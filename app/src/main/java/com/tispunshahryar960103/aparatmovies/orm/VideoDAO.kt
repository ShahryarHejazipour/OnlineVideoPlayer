package com.tispunshahryar960103.aparatmovies.orm

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tispunshahryar960103.aparatmovies.models.VideoVO


@Dao
interface VideoDAO {

    @Insert
    suspend fun insertVideo(videoVo:VideoVO):Long

    @Delete
    suspend fun deleteVideo(videoVo: VideoVO)

    @Query("select * from tbl_videoVO")
    suspend fun getAllVideos(): List<VideoVO>





}