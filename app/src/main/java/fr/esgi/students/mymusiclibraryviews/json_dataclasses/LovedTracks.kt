package fr.esgi.students.mymusiclibraryviews.json_dataclasses


import com.google.gson.annotations.SerializedName

data class LovedTracks(
    @SerializedName("loved")
    val loved: List<Loved>
)