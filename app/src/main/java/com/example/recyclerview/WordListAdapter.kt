package com.example.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView


class WordListAdapter(var mWordList: LinkedList<String>): RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wordlist_item, parent, false), this)
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val mCurrent = mWordList.get(position)
        holder.wordItemView?.setText(mCurrent)
    }

    class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var wordItemView: TextView? = null
        var mAdapter: WordListAdapter? = null

        constructor(itemView: View, adapter: WordListAdapter) : this(itemView) {
            super.itemView
            wordItemView = itemView.findViewById(R.id.word)
            this.mAdapter = adapter
        }
    }

}

