package com.example.encyclopedie

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PaysListAdapter (
    context: Context
) : RecyclerView.Adapter<PaysListAdapter.PaysViewHolder>() {

    companion object{
        val NOM="nom"
        val DESC="description"
        val SURFACE="surface"
        val POPULATION="population"
        val HISTO="histo"
        val RESOURCE="ressource"
        val PERSO="perso"
        val HYMNE="hymne"
        val FLAG="flag"
        val SLIDE1= "slide1"
        val SLIDE2= "slide2"
        val SLIDE3= "slide3"
        val VIDEOS= "videos"
        val TITLES="titles"

    }


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var pays = emptyList<Pays>() // Cached copy of pays
    private var listenerr: OnItemClickListener? = null

    inner class PaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val paysItemView: TextView = itemView.findViewById(R.id.title_data)


        fun PaysViewHolder(itemView: View) {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (listenerr != null && position != RecyclerView.NO_POSITION) {
                    listenerr!!.onItemClick(pays.get(position))
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaysViewHolder {
        val itemView = inflater.inflate(R.layout.itempays, parent, false)
        return PaysViewHolder(itemView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: PaysViewHolder, position: Int) {

        val current = pays[position]
        holder.paysItemView.text = current.nom

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, com.example.encyclopedie.PaysActivity::class.java)
            intent.putExtra(NOM,current.nom)
            intent.putExtra(DESC,current.description)
            intent.putExtra(SURFACE,current.surface)
            intent.putExtra(POPULATION,current.population)
            intent.putExtra(PERSO,current.personalite)
            intent.putExtra(HISTO,current.histo)
            intent.putExtra(RESOURCE,current.resource)
            intent.putExtra(HYMNE,current.hymne)
            intent.putExtra(FLAG,current.flag)
            intent.putExtra(SLIDE1,current.slide1)
            intent.putExtra(SLIDE2,current.slide2)
            intent.putExtra(SLIDE3,current.slide3)
            intent.putExtra(VIDEOS,current.videos)
            intent.putExtra(TITLES,current.titles)
            holder.itemView.context.startActivity(intent)
        }

    }

    fun getNoteAt(position: Int): Pays {
        return pays.get(position)
    }

    internal fun setWords(words: List<Pays>) {
        this.pays = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = pays.size



    interface OnItemClickListener {
        fun onItemClick(note: Pays)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        listenerr = listener
    }
}