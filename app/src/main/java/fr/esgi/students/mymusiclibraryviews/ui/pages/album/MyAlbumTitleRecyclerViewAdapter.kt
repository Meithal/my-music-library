package fr.esgi.students.mymusiclibraryviews.ui.pages.album

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

import fr.esgi.students.mymusiclibraryviews.ui.pages.album.placeholder.PlaceholderContent.PlaceholderItem
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentAlbumPageBinding
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Album
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.AlbumTracks

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyAlbumTitleRecyclerViewAdapter(
    private val values: LiveData<AlbumTracks>,
    private val lifecycleOwner: LifecycleOwner,
    ) : RecyclerView.Adapter<MyAlbumTitleRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentAlbumPageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        values.observe(lifecycleOwner) {
            //val item = values[position]
            holder.idView.text = (position + 1).toString()
            holder.contentView.text = it.track[position].strTrack
        }
    }

    override fun getItemCount(): Int = values.value?.track?.size ?: 0

    inner class ViewHolder(binding: FragmentAlbumPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}