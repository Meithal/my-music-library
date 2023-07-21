package fr.esgi.students.mymusiclibraryviews.json_dataclasses


import com.google.gson.annotations.SerializedName

data class AlbumTracks(
    @SerializedName("track")
    val track: List<Track>
)