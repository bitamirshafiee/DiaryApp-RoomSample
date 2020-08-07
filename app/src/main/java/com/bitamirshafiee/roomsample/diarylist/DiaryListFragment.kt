package com.bitamirshafiee.roomsample.diarylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bitamirshafiee.roomsample.R
import com.bitamirshafiee.roomsample.addeditdiary.AddEditFragment
import com.bitamirshafiee.roomsample.util.getViewModelFactory
import kotlinx.android.synthetic.main.fragment_diary_list.*

class DiaryListFragment : Fragment() {

    private val viewModel by viewModels<DiaryListViewModel> { getViewModelFactory() }
    private val adapter : DiaryAdapter by lazy {
        DiaryAdapter{
            (activity as DiaryActivity).showFragment(AddEditFragment.newInstance(it))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diary_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDiaries()

        lifecycle.addObserver(this.viewModel)

        recyclerView.adapter = adapter

        fab.setOnClickListener {
            (activity as DiaryActivity).showFragment(AddEditFragment.newInstance())
        }

        viewModel.allDiaries?.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    companion object{
        fun newInstance() : DiaryListFragment{
            return DiaryListFragment()
        }
    }
}