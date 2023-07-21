package fr.esgi.students.mymusiclibraryviews.ui.listings.hitsongs

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import fr.esgi.students.mymusiclibraryviews.R

import fr.esgi.students.mymusiclibraryviews.placeholder.PlaceholderContent.PlaceholderItem
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentHitsongBinding
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Loved
import kotlinx.coroutines.withContext

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyMusicHitSongRecyclerViewAdapter(
    private val values: LiveData<List<Loved>>,
    private val lifecycleOwner: LifecycleOwner,
    private val context: Context,
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

            holder.idView.text = (position + 1).toString()
            holder.contentView.text = item.strTrack
            holder.subContentView.text = item.strArtist
            Glide.with(context)

                .load(item.strTrackThumb)
                .placeholder(R.drawable.ic_dashboard_black_24dp)
                .into(holder.imageView)
            // holder.imageView =
        }
    }


    override fun getItemCount(): Int {
        //Log.d("Adapter Size ",values.value.toString())

        return values.value!!.size
    }

    inner class ViewHolder(binding: FragmentHitsongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.title
        val imageView = binding.imageView
        val subContentView = binding.subTitle

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}