package com.bitamirshafiee.roomsample.util

import androidx.fragment.app.Fragment
import com.bitamirshafiee.roomsample.DiaryApplication
import com.bitamirshafiee.roomsample.ViewModelFactory

fun Fragment.getViewModelFactory() : ViewModelFactory {
    val repository = (requireContext().applicationContext as DiaryApplication).diaryRepository
    return ViewModelFactory(repository, this)
}