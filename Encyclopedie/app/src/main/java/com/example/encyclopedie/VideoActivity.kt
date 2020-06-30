package com.example.encyclopedie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.list_video.*
import kotlinx.android.synthetic.main.list_youtube.*


class VideoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_video)

       val intent = intent
        title_listv.text ="Les dernier videos Youtube de " + intent.getStringExtra("search")
        recycler_viewv.layoutManager = LinearLayoutManager(this)


        recycler_viewv.adapter = VideoListAdapter(intent.getSerializableExtra(PaysListAdapter.VIDEOS) as ArrayList<String>,
            intent.getSerializableExtra(PaysListAdapter.TITLES) as ArrayList<String>)
    }
}