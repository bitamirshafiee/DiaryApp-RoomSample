package com.bitamirshafiee.roomsample.diarylist

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bitamirshafiee.roomsample.R

class DiaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        showFragment(DiaryListFragment.newInstance())
    }

    fun showFragment(frg : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, frg)
            .addToBackStack(frg.javaClass.name)
            .commit()
    }
}