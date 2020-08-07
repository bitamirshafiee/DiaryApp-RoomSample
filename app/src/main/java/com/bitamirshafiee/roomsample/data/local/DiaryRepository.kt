package com.bitamirshafiee.roomsample.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource

class DiaryRepository(appDataBase: AppDataBase) {

    private var diaryDao: DiaryDao = appDataBase.diaryDao()

    fun insert(diaryEntity: DiaryEntity) {
        diaryDao.insertDiary(diaryEntity)
    }

    fun getAllDiaries(): LiveData<List<DiaryEntity>> = diaryDao.getDiaries()

    fun getAllDiariesList(): DataSource.Factory<Int, DiaryEntity> = diaryDao.getDiariesList()

    fun updateDiary(diaryEntity: DiaryEntity) = diaryDao.updateDiary(diaryEntity)

    fun deleteDiary(diaryEntity: DiaryEntity) = diaryDao.deleteDiary(diaryEntity)
}