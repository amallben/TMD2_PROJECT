package com.example.encyclopedie

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.encyclopedie.model.Item
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class VideoListAdapter(
    val videos : List<String>, val titles : List<String>
) : RecyclerView.Adapter<VideoListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var pubVideo: VideoView

        var title : TextView
        init {

            pubVideo =  itemView.findViewById(R.id.video)

            title =  itemView.findViewById(R.id.title_v)


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_activty, parent, false)
        return ViewHolder(v)   }

    override fun getItemCount(): Int {
        return videos.size  }

    override fun onBindViewHolder(holder: VideoListAdapter.ViewHolder, position: Int) {
        val curr = videos[position]


        /******************loader la video*********************/


        holder.title.text = titles[position]

        val uri: Uri = Uri.parse(curr)
        holder.pubVideo.setVideoURI(uri)
        val mediaController = MediaController( holder.pubVideo.context)
        holder.pubVideo.setMediaController(mediaController)
        mediaController.setAnchorView( holder.pubVideo)
           }

}