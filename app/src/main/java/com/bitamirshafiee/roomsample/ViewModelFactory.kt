package com.bitamirshafiee.roomsample

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.bitamirshafiee.roomsample.data.local.DiaryRepository
import com.bitamirshafiee.roomsample.diarylist.DiaryListViewModel
import com.bitamirshafiee.roomsample.addeditdiary.AddEditDiaryViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val diaryRepository: DiaryRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(DiaryListViewModel::class.java) ->
                DiaryListViewModel(diaryRepository)
            isAssignableFrom(AddEditDiaryViewModel::class.java) ->
                AddEditDiaryViewModel(
                    diaryRepository
                )
            else ->
                throw IllegalArgumentException("UNKNOWN ViewModel class: ${modelClass.name}")
        }
    } as T
}