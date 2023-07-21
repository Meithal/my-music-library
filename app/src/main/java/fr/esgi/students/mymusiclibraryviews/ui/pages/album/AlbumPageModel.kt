package fr.esgi.students.mymusiclibraryviews.ui.pages.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Album

class AlbumPageModel : ViewModel() {
    private val _album = MutableLiveData<Album>()

    val album: LiveData<Album> = _album.map { _album.value!! }

    fun setAlbum(titles: Album) {
        _album.value = titles
    }

}