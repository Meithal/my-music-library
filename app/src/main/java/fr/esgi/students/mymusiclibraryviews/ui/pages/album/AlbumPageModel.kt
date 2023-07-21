package fr.esgi.students.mymusiclibraryviews.ui.pages.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.Album
import fr.esgi.students.mymusiclibraryviews.json_dataclasses.AlbumTracks

class AlbumPageModel : ViewModel() {
    private val _album = MutableLiveData<Album>()
    private val _tracks = MutableLiveData<AlbumTracks>()

    val album: LiveData<Album> = _album.map { _album.value!! }
    val tracks: LiveData<AlbumTracks> = _tracks.map { _tracks.value!! }

    fun setAlbum(titles: Album) {
        _album.value = titles
    }

    fun setTracks(tracks: AlbumTracks) {
        _tracks.value = tracks
    }

}