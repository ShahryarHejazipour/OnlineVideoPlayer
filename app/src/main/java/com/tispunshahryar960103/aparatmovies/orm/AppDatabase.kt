package com.tispunshahryar960103.aparatmovies.orm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tispunshahryar960103.aparatmovies.models.VideoVO
import com.tispunshahryar960103.aparatmovies.utils.Constants
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

@Database(entities = [VideoVO::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun getVideoDAO(): VideoDAO


    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        @Synchronized
        fun  getInstance(context: Context): AppDatabase {

            if (instance == null) {

                /*
            below code lines is for encrypting room database with SQLCipher
             */


                /*
            below code lines is for encrypting room database with SQLCipher
             */
                val data = charArrayOf('r', 'c', 't', '4')
                val passPhrase = SQLiteDatabase.getBytes(data)
                val supportFactory = SupportFactory(passPhrase)

                instance = Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATA_BASE_NAME.str)
                    .openHelperFactory(supportFactory) // this code line has added for encrypting room database with SQLCipher
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            }

            return instance as AppDatabase


        }


    }


}