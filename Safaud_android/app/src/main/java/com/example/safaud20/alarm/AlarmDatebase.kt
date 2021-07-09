package com.example.safaud20.alarm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


//
@Database(entities = arrayOf(alramData::class),version = 1, exportSchema = false)
abstract class AlarmDatebase : RoomDatabase(){

    abstract fun alarmDao() : AlarmDao

    private class DatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var alarmDao = database.alarmDao()
                    alarmDao.delete()

                    var word = alramData("hello")
                    alarmDao.insert(word)

                }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: AlarmDatebase? = null

            fun getDatabase(
                context: Context,
                scope: CoroutineScope
            ): AlarmDatebase {
                // if the INSTANCE is not null, then return it,
                // if it is, then create the database
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AlarmDatebase::class.java,
                        "time_database"
                    )
                        .addCallback(DatabaseCallback(scope))
                        .build()
                    INSTANCE = instance
                  //  return instance
                    instance

                }
            }

    }
}

