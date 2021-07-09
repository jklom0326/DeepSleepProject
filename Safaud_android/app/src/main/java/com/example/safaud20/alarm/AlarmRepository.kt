package com.example.safaud20.alarm

import androidx.lifecycle.LiveData

class AlarmRepository (private val alarmDao: AlarmDao){

    val alllist:LiveData<List<alramData>> = alarmDao.getAll()

    suspend fun insert(time : alramData){
        alarmDao.insert(time)
    }
}