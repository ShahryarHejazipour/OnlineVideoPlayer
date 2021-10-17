package com.tispunshahryar960103.aparatmovies.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class News(


    @SerializedName("icon")
    @Expose
    val icon: String,

    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("link")
    @Expose
    val link: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("type")
    @Expose
    val type: String
)