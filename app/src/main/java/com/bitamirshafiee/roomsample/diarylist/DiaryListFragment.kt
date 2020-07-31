package com.bitamirshafiee.roomsample.diarylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bitamirshafiee.roomsample.R
import com.bitamirshafiee.roomsample.util.getViewModelFactory
import kotlinx.android.synthetic.main.fragment_diary_list.*

class DiaryListFragment : Fragment() {

    private val viewModel by viewModels<DiaryListViewModel> { getViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDiaries()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diary_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(this.viewModel)
        viewModel.allDiaries?.observe(viewLifecycleOwner, Observer {
            recyclerView
        })
    }
}