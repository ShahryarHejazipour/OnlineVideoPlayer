package com.tispunshahryar960103.aparatmovies.models


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tbl_videoVO")
data class VideoVO(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val cat_id: Int,

    val creator: Int,

    val description: String,

    val icon: String,

    val link: String,

    val special: Int,

    val time: String,

    val title: String,

    val view: Int
):Parcelable