package fr.esgi.students.mymusiclibraryviews.ui.pages.track

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.esgi.students.mymusiclibraryviews.R

class TrackPageFragment : Fragment() {

    companion object {
        fun newInstance() = TrackPageFragment()
    }

    private lateinit var viewModel: TrackPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_track_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TrackPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}