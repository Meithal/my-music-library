package fr.esgi.students.mymusiclibraryviews.ui.pages.album

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import fr.esgi.students.mymusiclibraryviews.R
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentAlbumPageListBinding
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Album
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.AlbumTracks
import fr.esgi.students.mymusiclibraryviews.singletons.JsonHttpFetcher
import fr.esgi.students.mymusiclibraryviews.ui.pages.album.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class AlbumPageFragment : Fragment() {

    private var _binding: FragmentAlbumPageListBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    private var columnCount = 1
    private var albumId = "-1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("args", arguments?.getString("albumid").toString())

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
            albumId = it.getString("albumid")?:"-1"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumPageListBinding.inflate(inflater, container, false)
        //val view = inflater.inflate(R.layout.fragment_album_page_list, container, false)

        val recyclerView = binding.albumTrackList
        // Set the adapter
        with(recyclerView) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = MyAlbumTitleRecyclerViewAdapter(PlaceholderContent.ITEMS)
        }

        val albumModel =
            ViewModelProvider(this)[AlbumPageModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumModel =
            ViewModelProvider(this)[AlbumPageModel::class.java]

        JsonHttpFetcher.fetch(
            "https://theaudiodb.com/api/v1/json/523532/album.php?m=$albumId",
            requireContext(),
            {res ->
                Log.i("toto", res.toString())
                val albums = res.getJSONArray("album")
                val album = Gson().fromJson(albums[0].toString(), Album::class.java)
                albumModel.setAlbum(album)
            },
            { res -> Log.i("totoerr", res.toString())
                Toast.makeText(requireContext(), res.toString(), Toast.LENGTH_LONG).show()})

        albumModel.album.observe(viewLifecycleOwner) {
            Log.i("art", it.toString())
            binding.textAlbumArtist.text = it.strArtist
            binding.textAlbumArtist.text = it.strAlbum
        }

        JsonHttpFetcher.fetch(
            "https://theaudiodb.com/api/v1/json/523532/track.php?m=$albumId",
            requireContext(),
            {res ->
                Log.i("tototracks", res.toString())
                val tracks = Gson().fromJson(res.toString(), AlbumTracks::class.java)
                albumModel.setTracks(tracks)
            },
            { res ->
                Toast.makeText(requireContext(), res.toString(), Toast.LENGTH_LONG)
                    .show()
            }
        )

        albumModel.tracks.observe(viewLifecycleOwner) {
            Log.i("artt", it.toString())
            binding.intTrackNumber.text = "${it.track.size} tracks"
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            AlbumPageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}