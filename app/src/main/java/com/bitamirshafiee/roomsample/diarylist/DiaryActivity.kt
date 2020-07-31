package com.bitamirshafiee.roomsample.diarylist

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bitamirshafiee.roomsample.R

class DiaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, DiaryListFragment())
            .addToBackStack(DiaryListFragment().javaClass.name)
            .commit()

    }
}