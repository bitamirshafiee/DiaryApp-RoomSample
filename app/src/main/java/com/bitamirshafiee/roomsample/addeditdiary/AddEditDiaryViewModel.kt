package com.bitamirshafiee.roomsample.addeditdiary

import androidx.lifecycle.ViewModel
import com.bitamirshafiee.roomsample.data.local.DiaryEntity
import com.bitamirshafiee.roomsample.data.local.DiaryRepository

class AddEditDiaryViewModel(
    private val diaryRepository: DiaryRepository
) : ViewModel(){

    fun insertDiary(diaryEntity: DiaryEntity){
        diaryRepository.insert(diaryEntity)
    }

    fun deleteDiary(diaryEntity: DiaryEntity){
        diaryRepository.deleteDiary(diaryEntity)
    }

    fun updateDiary(diaryEntity: DiaryEntity){
        diaryRepository.updateDiary(diaryEntity)
    }

}