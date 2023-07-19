package fr.esgi.students.mymusiclibraryviews.ui.listings.hitsongs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Loved

class MusicHitSongModel : ViewModel() {
    private val _hitsongs = MutableLiveData<List<Loved>>()

    val hitTitles = _hitsongs.map { _hitsongs.value }

    fun setTitles(titles: List<Loved>) {
        _hitsongs.value = titles
    }
}