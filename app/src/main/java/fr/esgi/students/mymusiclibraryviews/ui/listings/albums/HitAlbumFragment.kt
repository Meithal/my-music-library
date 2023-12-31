package fr.esgi.students.mymusiclibraryviews.ui.listings.albums

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
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.google.gson.Gson
import fr.esgi.students.mymusiclibraryviews.R
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Album
import fr.esgi.students.mymusiclibraryviews.singletons.JsonHttpFetcher

/**
 * A fragment representing a list of Items.
 */
class HitAlbumFragment : Fragment() {

    private var columnCount = 1
    //private lateinit var binding: FragmentItemListBinding

    inner class OnAlbumClick {
        fun onClick(album: Album) {
            Log.d("totoclick", album.strAlbum)

            val bundle = Bundle()
            bundle.putString("albumid", album.idAlbum)
            Navigation.findNavController(
                this@HitAlbumFragment.requireActivity(),R.id.nav_host_fragment_activity_main
            ).navigate(
                R.id.action_navigation_home_to_albumPageFragment,
                bundle
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

        //binding = FragmentItemListBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hitsong_list, container, false)

        val musicHitSongModel =
            ViewModelProvider(this)[MusicAlbumsHitsModel::class.java]


        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyAlbumRecyclerViewAdapter(
                    musicHitSongModel.hitTitles,
                    this@HitAlbumFragment,
                    context,
                    OnAlbumClick()
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


//        val url = "https://www.theaudiodb.com/api/v1/json/2/search.php?s=coldplay"
//
//        val jsonObjectRequest = JsonObjectRequest(
//            Request.Method.GET, url, null,
//            { response ->
//                view.findViewById<TextView>(R.id.textAlbum).text = "Response: %s".format(response.toString())
//            },
//            { error ->
//                view.findViewById<TextView>(R.id.textAlbum).text = "Error " + error.toString()
//            }
//        )
//
//        // Access the RequestQueue through your singleton class.
//        VolleyQueue.getInstance(requireContext()).addToRequestQueue(jsonObjectRequest)

        val homeViewModel =
            ViewModelProvider(this)[MusicAlbumsHitsModel::class.java]

        val tracks = ArrayList<Album>()

        JsonHttpFetcher.fetch(
            "https://theaudiodb.com/api/v1/json/523532/mostloved.php?format=album",
            requireContext(),
            {res ->
                Log.i("toto", res.toString())
                val tracksSerial = res.getJSONArray("loved")
                for (i in 0 until tracksSerial.length()) {
                    tracks.add(Gson().fromJson(tracksSerial[i].toString(), Album::class.java))
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
            HitAlbumFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}