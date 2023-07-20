package fr.esgi.students.mymusiclibraryviews.ui.listings.hitsongs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import fr.esgi.students.mymusiclibraryviews.R
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Loved
import fr.esgi.students.mymusiclibraryviews.singletons.JsonHttpFetcher

/**
 * A fragment representing a list of Items.
 */
class MusicHitSongFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hitsong_list, container, false)

        val musicHitSongModel =
            ViewModelProvider(this)[MusicHitSongModel::class.java]

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                adapter = MyMusicHitSongRecyclerViewAdapter(
                    musicHitSongModel.hitTitles,
                    this@MusicHitSongFragment,
                    context
                )

                musicHitSongModel.hitTitles.observe(viewLifecycleOwner) {
                    adapter!!.notifyDataSetChanged()
                }

            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel =
            ViewModelProvider(this)[MusicHitSongModel::class.java]

        val tracks = ArrayList<Loved>()

        JsonHttpFetcher.fetch(
            "https://theaudiodb.com/api/v1/json/523532/mostloved.php?format=track",
            requireContext(),
            {res ->
                Log.i("toto", res.toString())
                val tracksSerial = res.getJSONArray("loved")
                for (i in 0 until tracksSerial.length()) {
                    tracks.add(Gson().fromJson(tracksSerial[i].toString(), Loved::class.java))
                }
                Log.i("tata", tracks.toString())

                homeViewModel.setTitles(tracks)
            },
            { res -> Log.i("totoerr", res.toString())
                Toast.makeText(requireContext(), res.toString(), Toast.LENGTH_LONG).show()})
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            MusicHitSongFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
