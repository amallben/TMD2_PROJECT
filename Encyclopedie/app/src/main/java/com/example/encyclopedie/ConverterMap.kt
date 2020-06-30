package com.example.encyclopedie

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken

class ConverterMap {

    @TypeConverter
    fun stringToMap(value: JsonElement): HashMap<String, String> {
        return Gson().fromJson(value,  object : TypeToken<Map<String, String>>() {}.type)
    }

    @TypeConverter
    fun mapToString(value: HashMap<String, String>?): String {
        return if(value == null) "" else Gson().toJson(value)
    }
}