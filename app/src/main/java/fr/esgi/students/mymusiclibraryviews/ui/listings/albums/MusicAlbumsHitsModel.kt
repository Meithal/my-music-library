package fr.esgi.students.mymusiclibraryviews.ui.listings.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Album
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Loved

class MusicAlbumsHitsModel : ViewModel() {
    private val _hitalbums = MutableLiveData<List<Album>>(ArrayList())

    val hitTitles: LiveData<List<Album>> = _hitalbums.map { _hitalbums.value!! }

    fun setTitles(titles: List<Album>) {
        _hitalbums.value = titles
    }
}