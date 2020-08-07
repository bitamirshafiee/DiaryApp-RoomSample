package com.bitamirshafiee.roomsample.addeditdiary

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.bitamirshafiee.roomsample.R
import com.bitamirshafiee.roomsample.data.local.DiaryEntity
import com.bitamirshafiee.roomsample.util.getViewModelFactory
import kotlinx.android.synthetic.main.fragment_add_edit.*

private const val DIARY_ENTITY = "DIARY"

class AddEditFragment : Fragment() {

    private var isUpdate: Boolean = false

    private val viewModel by viewModels<AddEditDiaryViewModel> { getViewModelFactory() }

    private var diaryEntity: DiaryEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            diaryEntity = it.getParcelable(DIARY_ENTITY)
            diaryEntity?.let {
                isUpdate = true
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isUpdate) {
            delete_diary_image_view.visibility = View.VISIBLE
            diaryEntity?.let { diary ->
                diary_edit_text.setText(diary.text)
            }
        }

        save_diary_image_view.setOnClickListener {

            if (isUpdate) {
                updateDiary()
            } else {
                insertDiary()
            }
        }

        delete_diary_image_view.setOnClickListener {
            deleteDiary()
        }
    }

    private fun insertDiary() {
        val diary = DiaryEntity(text = diary_edit_text.text.toString())
        viewModel.insertDiary(diary)
        activity?.supportFragmentManager?.popBackStack()
        toast(R.string.str_diary_is_saved)
    }

    private fun updateDiary() {
        diaryEntity?.let {
            val diary = DiaryEntity(it.uid, diary_edit_text.text.toString())
            viewModel.updateDiary(diary)
        }
        activity?.supportFragmentManager?.popBackStack()
        toast(R.string.str_diary_is_updated)
    }

    private fun deleteDiary() {
        diaryEntity?.let {
            val diary = DiaryEntity(it.uid, it.text)
            viewModel.deleteDiary(diary)
        }
        activity?.supportFragmentManager?.popBackStack()
        toast(R.string.str_diary_is_deleted)
    }

    private fun toast(@StringRes id : Int){
        Toast.makeText(activity, resources.getString(id), Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(diaryEntity: DiaryEntity? = null) =
            AddEditFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(DIARY_ENTITY, diaryEntity)
                }
            }
    }
}