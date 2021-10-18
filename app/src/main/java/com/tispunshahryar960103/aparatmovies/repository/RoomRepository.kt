package com.tispunshahryar960103.aparatmovies.repository

import com.tispunshahryar960103.aparatmovies.models.VideoVO
import com.tispunshahryar960103.aparatmovies.orm.VideoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomRepository(private val videoDAO: VideoDAO) {

    private val dispatcher=Dispatchers.IO



    suspend fun insertVideo(videoVO: VideoVO):Long{
       return withContext(dispatcher){
            videoDAO.insertVideo(videoVO)
        }

    }

    suspend fun deleteVideo(videoVO: VideoVO){
        withContext(dispatcher){
            videoDAO.deleteVideo(videoVO)
        }
    }

    suspend fun getAllVideos():List<VideoVO>{
        return withContext(dispatcher){
            videoDAO.getAllVideos()
        }
    }




}