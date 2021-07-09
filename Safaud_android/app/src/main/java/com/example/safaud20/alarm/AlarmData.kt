package com.example.safaud20.alarm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "alramData")

data class alramData(@PrimaryKey @ColumnInfo(name = "time") val time:String)

