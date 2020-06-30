package com.example.encyclopedie

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.encyclopedie.PaysListAdapter.Companion.DESC
import com.example.encyclopedie.PaysListAdapter.Companion.FLAG
import com.example.encyclopedie.PaysListAdapter.Companion.HISTO
import com.example.encyclopedie.PaysListAdapter.Companion.HYMNE
import com.example.encyclopedie.PaysListAdapter.Companion.NOM
import com.example.encyclopedie.PaysListAdapter.Companion.PERSO
import com.example.encyclopedie.PaysListAdapter.Companion.POPULATION
import com.example.encyclopedie.PaysListAdapter.Companion.RESOURCE
import com.example.encyclopedie.PaysListAdapter.Companion.SLIDE1
import com.example.encyclopedie.PaysListAdapter.Companion.SLIDE2
import com.example.encyclopedie.PaysListAdapter.Companion.SLIDE3
import com.example.encyclopedie.PaysListAdapter.Companion.SURFACE
import com.example.encyclopedie.PaysListAdapter.Companion.TITLES
import com.example.encyclopedie.PaysListAdapter.Companion.VIDEOS
import kotlinx.android.synthetic.main.pays_activity.*


class PaysActivity:AppCompatActivity(),  View.OnClickListener {
    lateinit var itemlist:ArrayList<String>
    lateinit var adapter:ArrayAdapter<String>
    lateinit var videos:ArrayList<String>
    lateinit var titles:ArrayList<String>
    private var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.pays_activity)

        val intent = intent

        nom.text = intent.getStringExtra(NOM)
        descreption.text = intent.getStringExtra(DESC)
        surface.text = "Surface : " + intent.getIntExtra(SURFACE,1)
        population.text = "Population : " + intent.getIntExtra(POPULATION,1)

        itemlist= arrayListOf<String>()
        adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemlist)

        val histor =
            intent.getSerializableExtra(HISTO) as ArrayList<String>
        Populate(histor,histo)

        val resourc =
            intent.getSerializableExtra(RESOURCE) as ArrayList<String>
        Populate(resourc,reso)

        val person =
            intent.getSerializableExtra(PERSO) as ArrayList<String>
        Populate(person,perso)

         videos = intent.getSerializableExtra(VIDEOS) as ArrayList<String>
         titles =  intent.getSerializableExtra(TITLES) as ArrayList<String>
        //val resID = resources.getIdentifier("hymne_algerie", "raw", packageName)
        player = MediaPlayer.create(
            this,
             intent.getIntExtra(HYMNE,1)
        )
        player!!.isLooping = true

        img.setImageResource(intent.getIntExtra(FLAG,1))


        val image1 : Int = intent.getIntExtra(SLIDE1,1)
        val image2 : Int = intent.getIntExtra(SLIDE2,1)
        val image3 : Int = intent.getIntExtra(SLIDE3,1)

        FliperImage(image1)
        FliperImage(image2)
        FliperImage(image3)
        sound.setOnClickListener(this)
        pause.setOnClickListener(this)
        youtubebtn.setOnClickListener(this)
        videobtn.setOnClickListener(this)
    }

    fun Populate(list :ArrayList<String> , view :ListView)
    { itemlist= arrayListOf<String>()
        adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemlist)
        for (item in list){
            itemlist.add(item)
        }
        view.adapter =  adapter
        adapter.notifyDataSetChanged()
    }
    fun FliperImage (image : Int)
    {
        var ImageView = ImageView(this)
        ImageView.setBackgroundResource(image)

        slideshow.addView(ImageView)
        slideshow.flipInterval = 4000
        slideshow.isAutoStart = true

        slideshow.setInAnimation(this,android.R.anim.slide_in_left )
        slideshow.setOutAnimation(this,android.R.anim.slide_out_right)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.sound -> {
                player!!.start()
                sound.visibility= View.GONE
                pause.visibility= View.VISIBLE
            }
            R.id.pause -> {
                player!!.pause()
                pause.visibility= View.GONE
                sound.visibility= View.VISIBLE

            }
            R.id.youtubebtn -> {
                val intent2 = Intent(this,YoutubeActivity::class.java)
                intent2.putExtra("search",intent.getStringExtra(NOM))
                startActivity(intent2)
            }
            R.id.videobtn -> {
                val intent3 = Intent(this,VideoActivity::class.java)
                intent3.putExtra("search",nom.text)
                intent3.putExtra(VIDEOS,videos )
                intent3.putExtra(TITLES,titles)
                startActivity(intent3)
            }
        }
    }
}