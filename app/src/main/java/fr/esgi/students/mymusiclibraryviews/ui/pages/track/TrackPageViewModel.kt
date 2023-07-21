package fr.esgi.students.mymusiclibraryviews.ui.pages.track

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Track

class TrackPageViewModel : ViewModel() {

    private val _track = MutableLiveData<Track>()

    val track: LiveData<Track> = _track.map { _track.value!! }

    fun setTrack(track: Track) {
        _track.value = track
    }

}