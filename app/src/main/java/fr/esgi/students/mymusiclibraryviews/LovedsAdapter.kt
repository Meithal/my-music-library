package fr.esgi.students.mymusiclibraryviews

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LovedsAdapter(val list: List<Loved>, val param: OnLovedClickListener) : RecyclerView.Adapter<LovedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LovedViewHolder {
        return LovedViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LovedViewHolder, position: Int) {
        Log.d("ESGI", position.toString())
        val loved = list[position]
        holder.update(loved)
        holder.itemView.setOnClickListener {
            param.onLovedClicked(loved)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class LovedViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    private val text: TextView = v.findViewById(R.id.strArtist)

    fun update(loved: Loved) {
        text.text = loved.idAlbum
    }

}

interface OnLovedClickListener {
    fun onLovedClicked(loved: Loved)
}