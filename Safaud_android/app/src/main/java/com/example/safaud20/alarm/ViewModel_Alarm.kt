package com.example.safaud20.alarm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class TimeViewModel(application: Application) : AndroidViewModel(application){

    private val repository : AlarmRepository
    val alllist: LiveData<List<alramData>>

    init {
        val alarmdao = AlarmDatebase.getDatabase(application,viewModelScope).alarmDao()
        repository = AlarmRepository(alarmdao)
        alllist = repository.alllist
    }

    fun insert(time : alramData) = viewModelScope.launch {
        repository.insert(time)
    }
}