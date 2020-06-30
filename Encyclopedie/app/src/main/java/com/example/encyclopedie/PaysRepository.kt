package com.example.encyclopedie

import android.os.AsyncTask
import androidx.lifecycle.LiveData

class PaysRepository(private val paysDao: PaysDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Pays>> = paysDao.getAlphabetizedWords()


    suspend fun insert(pays: Pays) {
        //wordDao.insert(word)
        InsertNoteAsyncTask(paysDao).execute(pays)


    }
    private class InsertNoteAsyncTask(private val paysDoa: PaysDao?) :
        AsyncTask<Pays?, Void?, Void?>() {


        protected override fun doInBackground(vararg params: Pays?): Void? {
            paysDoa!!.insert(params[0])
            return null   }

    }

    fun delete(pays: Pays) {
        DeleteNoteAsyncTask(paysDao).execute(pays)
    }

    private class DeleteNoteAsyncTask(private val paysDoa: PaysDao) :
        AsyncTask<Pays?, Void?, Void?>() {


        override fun doInBackground(vararg params: Pays?): Void? {
            paysDoa.delete(params[0])
            return null   }

    }

    fun update(note: Pays) {
        UpdateNoteAsyncTask(paysDao).execute(note)
    }
    private class UpdateNoteAsyncTask(private val paysDoa: PaysDao) :
        AsyncTask<Pays, Void?, Void?>() {


        override fun doInBackground(vararg params: Pays): Void? {
            paysDoa.update(params[0])
            return null }

    }


}