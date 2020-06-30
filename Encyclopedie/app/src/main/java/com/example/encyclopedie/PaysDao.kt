package com.example.encyclopedie

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PaysDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from pays_table ORDER BY nom ASC")
    fun getAlphabetizedWords(): LiveData<List<Pays>>


    //    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(word: Word)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pays: Pays?)

    @Delete
    fun delete(pays: Pays?)

    @Update
    fun update(pays: Pays?)

    @Query("DELETE FROM pays_table")
    fun deleteAll()
}