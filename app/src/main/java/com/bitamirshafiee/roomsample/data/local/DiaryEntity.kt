package com.bitamirshafiee.roomsample.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "diaries")
data class DiaryEntity(
    @PrimaryKey @ColumnInfo(name = "entryid") val uid : String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "text") val text : String) : Parcelable