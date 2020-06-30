package com.example.encyclopedie


import android.app.PendingIntent.getActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.encyclopedie.model.video
import com.example.encyclopedie.model.Item
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.list_youtube.*
import okhttp3.*

import java.io.IOException

class YoutubeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_youtube)
        val intent = intent
        title_listy.text ="Les dernier videos Youtube de " + intent.getStringExtra("search")
        recycler_viewy.layoutManager = LinearLayoutManager(this)

        GetVideos(intent.getStringExtra("search"))
    }

    private fun GetVideos(s : String) {
        val url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=5&order=date&q="+s+"&type=video&key=AIzaSyAvwEQzek_LSont6cZdI9ERmvk4fSp6FGw"


        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()


                val gson = GsonBuilder().create()

                val repos: video = gson.fromJson(body, video::class.java)
                 val videos  = repos.items


                runOnUiThread {
                    recycler_viewy.adapter = YoutubeListAdapter(videos)
                }


            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }
}