package com.bitamirshafiee.roomsample

import android.content.Context
import androidx.room.Room
import com.bitamirshafiee.roomsample.data.local.AppDataBase
import com.bitamirshafiee.roomsample.data.local.DiaryRepository

object ServiceLocator {
    @Volatile
    var diaryRepository: DiaryRepository? = null

    fun provideTaskRepository(context: Context): DiaryRepository {
        synchronized(this) {
            return diaryRepository ?: createDiaryRepository(context)
        }
    }

    private fun createDiaryRepository(context: Context): DiaryRepository =
        DiaryRepository(createDataBase(context))


    private fun createDataBase(context: Context): AppDataBase =
        Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java, "Diaries.db"
        ).build()
}