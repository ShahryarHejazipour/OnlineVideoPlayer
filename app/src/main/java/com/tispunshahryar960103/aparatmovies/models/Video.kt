package com.tispunshahryar960103.aparatmovies.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Video(

    @SerializedName("cat_id")
    @Expose
    val cat_id: String,
    @SerializedName("creator")
    @Expose
    val creator: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("icon")
    @Expose
    val icon: String,
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("link")
    @Expose
    val link: String,
    @SerializedName("special")
    @Expose
    val special: String,
    @SerializedName("time")
    @Expose
    val time: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("view")
    @Expose
    val view: String
):Parcelable