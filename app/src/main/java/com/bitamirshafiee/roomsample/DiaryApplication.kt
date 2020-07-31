package com.bitamirshafiee.roomsample

import android.app.Application
import com.bitamirshafiee.roomsample.data.local.DiaryRepository

class DiaryApplication : Application() {

    val diaryRepository: DiaryRepository
        get() = ServiceLocator.provideTaskRepository(this)
}