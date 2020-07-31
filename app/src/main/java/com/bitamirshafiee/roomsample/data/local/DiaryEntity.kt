package com.bitamirshafiee.roomsample.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diaries")
data class DiaryEntity(
    @PrimaryKey(autoGenerate = true) val uid : Int,
    @ColumnInfo(name = "text") val text : String)