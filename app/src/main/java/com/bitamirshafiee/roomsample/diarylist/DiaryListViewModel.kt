package com.bitamirshafiee.roomsample.diarylist

import androidx.lifecycle.*
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.bitamirshafiee.roomsample.data.local.DiaryEntity
import com.bitamirshafiee.roomsample.data.local.DiaryRepository

class DiaryListViewModel(private val diaryRepository: DiaryRepository) : ViewModel(),
    LifecycleObserver {

    var allDiaries: LiveData<PagedList<DiaryEntity>>? = null

    fun getDiaries() {
        allDiaries = diaryRepository.getAllDiariesList().toLiveData(
            Config(
                pageSize = 10,
                enablePlaceholders = false,
                maxSize = 100
            )
        )
    }

}