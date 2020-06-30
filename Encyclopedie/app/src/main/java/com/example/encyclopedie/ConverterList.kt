package com.example.encyclopedie

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class ConverterList{


        var gson: Gson = Gson()
        @TypeConverter
        fun stringToSomeObjectList(data: String?): ArrayList<String> {

            val listType =
                object : TypeToken<ArrayList<String?>?>() {}.type
            return Gson().fromJson(data, listType)
        }

        @TypeConverter
        fun someObjectListToString(someObjects: ArrayList<String?>?): String {
            return gson.toJson(someObjects)
        }

}