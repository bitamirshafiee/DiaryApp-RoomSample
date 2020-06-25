package com.bitamirshafiee.roomsample.data.local

import androidx.room.Entity

@Entity(tableName = "diaries")
data class DiaryEntity(val text : String)