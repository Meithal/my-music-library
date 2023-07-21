package fr.esgi.students.mymusiclibraryviews.ui.pages.track

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import fr.esgi.students.mymusiclibraryviews.R
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentSearchBinding
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentTrackPageBinding
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Album
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Track
import fr.esgi.students.mymusiclibraryviews.singletons.JsonHttpFetcher
import fr.esgi.students.mymusiclibraryviews.ui.pages.album.AlbumPageModel

class TrackPageFragment : Fragment() {

    companion object {
        fun newInstance() = TrackPageFragment()
    }

    private lateinit var viewModel: TrackPageViewModel

    private var trackId = "-1"

    private var _binding: FragmentTrackPageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            trackId = it.getString("trackId")?:"-1"
        }

        viewModel = ViewModelProvider(this).get(TrackPageViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrackPageBinding.inflate(inflater, container, false)

        //return inflater.inflate(R.layout.fragment_track_page, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("qwer", trackId)

        JsonHttpFetcher.fetch(
            "https://theaudiodb.com/api/v1/json/523532/track.php?h=$trackId",
            requireContext(),
            {res ->
                Log.i("toto", res.toString())

                val tracks = res.getJSONArray("track")
                val track = Gson().fromJson(tracks[0].toString(), Track::class.java)
                viewModel.setTrack(track = track)
            },
            { res -> Log.i("totoerr", res.toString())
                Toast.makeText(requireContext(), res.toString(), Toast.LENGTH_LONG).show()})

            viewModel.track.observe(viewLifecycleOwner) {
                binding.trackTitle.text = it.strTrack
                binding.trackLyrics.text = it.strTrackLyrics
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}