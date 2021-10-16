package com.tispunshahryar960103.aparatmovies.webService

import android.util.Base64
import com.tispunshahryar960103.aparatmovies.utils.Constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.UnsupportedEncodingException
import java.util.*

object ApiClient {

    private val BASE_URL:String= getSecureBaseUrl()



    init {
        System.loadLibrary(Constants.LOAD_LIBRARY.str);
    }

    private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getClient():Retrofit{
        return retrofit
    }


    external fun getUrl():String

    private fun getSecureBaseUrl():String{

        var myUrl:String= getUrl()

        try {
            return String(Base64.decode(myUrl, Base64.DEFAULT), charset("UTF-8"))
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace();
        }

        myUrl="https://google.com"

        return myUrl




    }







}