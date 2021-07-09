package com.example.safaud20.alarm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlarmDao {

    @Query("SELECT * FROM alramData ORDER BY time DESC LIMIT 10")
    fun getAll() : LiveData<List<alramData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(time: alramData)

    @Query("DELETE FROM alramData")
    suspend fun delete()
}