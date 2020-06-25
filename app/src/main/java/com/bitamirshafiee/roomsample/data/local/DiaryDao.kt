package com.bitamirshafiee.roomsample.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

@Dao
interface DiaryDao{

    @Query("SELECT * FROM diaries")
    fun getDiaries() : LiveData<List<DiaryEntity>>

    @Insert
    fun insertDiary(diaryEntity: DiaryEntity)

    @Update
    fun updateDiary(diaryEntity: DiaryEntity)

    @Delete
    fun deleteDiary(diaryEntity: DiaryEntity)

    @Query("SELECT * FROM diaries")
    fun getDiariesList() : DataSource.Factory<Int, DiaryEntity>
}