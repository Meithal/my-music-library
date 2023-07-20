package fr.esgi.students.mymusiclibraryviews.ui.listings.hitsongs

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

import fr.esgi.students.mymusiclibraryviews.placeholder.PlaceholderContent.PlaceholderItem
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentHitsongBinding
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Loved

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyMusicHitSongRecyclerViewAdapter(
    private val values: LiveData<List<Loved>>,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<MyMusicHitSongRecyclerViewAdapter.ViewHolder>() {

    var listSize = 2
    init {
        values.observe(lifecycleOwner) {
            it -> listSize= it.size
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentHitsongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values.observe(lifecycleOwner) {
            val item = it!![position]

            holder.idView.text = item.strTrack
            holder.contentView.text = item.strArtist
        }
    }


    override fun getItemCount(): Int {
        Log.d("Adapter Size ",values.value.toString())

        return values.value!!.size
    }

    inner class ViewHolder(binding: FragmentHitsongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}