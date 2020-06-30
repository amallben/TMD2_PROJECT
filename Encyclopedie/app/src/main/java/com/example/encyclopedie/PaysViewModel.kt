package com.example.encyclopedie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PaysViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: PaysRepository
    // LiveData gives us updated words when they change.
    val allWords: LiveData<List<Pays>>
   

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val paysDao = PaysDataBase.getDatabase(application, viewModelScope).paysDao()
        repository = PaysRepository(paysDao)
        allWords = repository.allWords

    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on the mainthread, blocking
     * the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called viewModelScope which we
     * can use here.
     */
    fun insert(pays: Pays) = viewModelScope.launch {
        repository.insert(pays)
    }
    fun delete(pays: Pays) {
        repository.delete(pays)
    }
    fun update(pays: Pays) {
        repository.update(pays)
    }
}
