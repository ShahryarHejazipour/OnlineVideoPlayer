package com.tispunshahryar960103.aparatmovies.utils

import android.content.Context
import android.content.SharedPreferences
import com.securepreferences.SecurePreferences


class AppConfig(val context: Context) {

    companion object {
        init {
            System.loadLibrary(Constants.LOAD_LIBRARY.str)
        }
    }


    private var editor: SharedPreferences.Editor
    var sharedPreferences:SharedPreferences

    init {

        sharedPreferences =
            SecurePreferences(context, getKeyAlias(), getSharedFileName())

        editor = sharedPreferences.edit()

    }


    fun setUserId(id:Int){

        editor.putInt("userId",id)
        editor.apply()

    }

    fun getLoginCode():Int{
        return sharedPreferences.getInt("userId",0)
    }





    private external fun getKeyAlias(): String
    private external fun getSharedFileName(): String

}