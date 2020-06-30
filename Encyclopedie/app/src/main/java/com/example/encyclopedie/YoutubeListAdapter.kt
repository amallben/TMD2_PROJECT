package com.example.encyclopedie


import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.encyclopedie.model.Item
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import java.text.SimpleDateFormat

class YoutubeListAdapter (
    val videoss : List<Item>
) :RecyclerView.Adapter<YoutubeListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var pubVideo: YouTubePlayerView
        var time : TextView
        var title : TextView
        init {

            pubVideo =  itemView.findViewById(R.id.youtube)
            time =  itemView.findViewById(R.id.time)
            title =  itemView.findViewById(R.id.title_ytb)


        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.youtube_activity, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return videoss.size
         }


    override fun onBindViewHolder(holder: YoutubeListAdapter.ViewHolder, position: Int) {

        val curr = videoss[position]


        /******************loader la video*********************/

        holder.time.text = curr.snippet.publishedAt
        holder.title.text = curr.snippet.title
        holder.pubVideo.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer)
            {
                println("hhhhhhhhhhhhhhhhh"+curr.id.videoId)
                youTubePlayer.cueVideo(curr.id.videoId, 0f)

            }
        })
    }
}