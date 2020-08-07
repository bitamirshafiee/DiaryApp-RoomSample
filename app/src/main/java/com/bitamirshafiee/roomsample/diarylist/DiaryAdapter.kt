package com.bitamirshafiee.roomsample.diarylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bitamirshafiee.roomsample.R
import com.bitamirshafiee.roomsample.data.local.DiaryEntity
import kotlinx.android.synthetic.main.item_diary.view.*

class DiaryAdapter(val onClick: (DiaryEntity) -> Unit) : PagedListAdapter<DiaryEntity, DiaryAdapter.ViewHolder>(DiaryDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_diary, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }

    }

    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(diary: DiaryEntity) {
            view.diary_text_view.text = diary.text
            view.root_view.setOnClickListener {
                onClick(diary)
            }
        }
    }
}


class DiaryDiffCallBack : DiffUtil.ItemCallback<DiaryEntity>() {
    override fun areItemsTheSame(oldItem: DiaryEntity, newItem: DiaryEntity): Boolean {
        return oldItem.uid == newItem.uid
    }

    override fun areContentsTheSame(oldItem: DiaryEntity, newItem: DiaryEntity): Boolean {
        return oldItem == newItem
    }
}