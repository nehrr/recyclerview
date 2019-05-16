package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.util.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private val mWordList: LinkedList<String> = LinkedList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fab: View = findViewById(R.id.fab)

        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }

        var mRecyclerView: RecyclerView = findViewById(R.id.recyclerview)
        var mAdapter: WordListAdapter = WordListAdapter(mWordList)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener{
            val wordListSize: Int = mWordList.size
            mWordList.addLast("Word $wordListSize")
            mRecyclerView.adapter?.notifyItemInserted(wordListSize)
            mRecyclerView.smoothScrollToPosition(wordListSize)
        }
    }
}
