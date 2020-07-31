package com.bitamirshafiee.roomsample.diarylist

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bitamirshafiee.roomsample.R
import com.bitamirshafiee.roomsample.data.local.DiaryEntity
import kotlinx.android.synthetic.main.item_diary.view.*

class DiaryAdapter : PagedListAdapter<DiaryEntity, ViewHolder>(DiaryDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }

    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(diary: DiaryEntity) {
            view.diary_text.text = diary.text
        }

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {

                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_diary, parent, false)

                return ViewHolder(view)
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