package com.bitamirshafiee.roomsample.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bitamirshafiee.roomsample.data.local.DiaryDao
import com.bitamirshafiee.roomsample.data.local.DiaryEntity

@Database(entities = [DiaryEntity::class], version = 1, exportSchema = true)
abstract class AppDataBase : RoomDatabase() {

    abstract fun diaryDao(): DiaryDao
}

