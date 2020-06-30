package com.example.encyclopedie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pays_table")
data class Pays(@PrimaryKey @ColumnInfo(name = "nom") val nom: String, val description: String,
                val surface: Int, val population: Int, val histo :ArrayList<String>
                , val resource : ArrayList<String>, val personalite :ArrayList<String>,
                val hymne: Int, val flag :Int,
                val slide1: Int , val slide2:Int, val slide3 : Int
                , val videos:ArrayList<String>,val titles:ArrayList<String>)