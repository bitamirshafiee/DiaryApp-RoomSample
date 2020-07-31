package com.bitamirshafiee.roomsample.diarylist

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val repository: DiaryRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>) =
            DiaryListViewModel(repository) as T
    }

}