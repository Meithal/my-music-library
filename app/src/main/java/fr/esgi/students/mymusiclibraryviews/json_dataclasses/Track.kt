package fr.esgi.students.mymusiclibraryviews.json_dataclasses


import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("idAlbum")
    val idAlbum: String,
    @SerializedName("idArtist")
    val idArtist: String,
    @SerializedName("idIMVDB")
    val idIMVDB: Any?,
    @SerializedName("idLyric")
    val idLyric: String,
    @SerializedName("idTrack")
    val idTrack: String,
    @SerializedName("intCD")
    val intCD: Any?,
    @SerializedName("intDuration")
    val intDuration: String,
    @SerializedName("intLoved")
    val intLoved: String,
    @SerializedName("intMusicVidComments")
    val intMusicVidComments: Any?,
    @SerializedName("intMusicVidDislikes")
    val intMusicVidDislikes: Any?,
    @SerializedName("intMusicVidFavorites")
    val intMusicVidFavorites: Any?,
    @SerializedName("intMusicVidLikes")
    val intMusicVidLikes: Any?,
    @SerializedName("intMusicVidViews")
    val intMusicVidViews: Any?,
    @SerializedName("intScore")
    val intScore: Any?,
    @SerializedName("intScoreVotes")
    val intScoreVotes: Any?,
    @SerializedName("intTotalListeners")
    val intTotalListeners: Any?,
    @SerializedName("intTotalPlays")
    val intTotalPlays: Any?,
    @SerializedName("intTrackNumber")
    val intTrackNumber: String,
    @SerializedName("strAlbum")
    val strAlbum: String,
    @SerializedName("strArtist")
    val strArtist: String,
    @SerializedName("strArtistAlternate")
    val strArtistAlternate: Any?,
    @SerializedName("strDescriptionCN")
    val strDescriptionCN: Any?,
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: Any?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strDescriptionES")
    val strDescriptionES: Any?,
    @SerializedName("strDescriptionFR")
    val strDescriptionFR: Any?,
    @SerializedName("strDescriptionHU")
    val strDescriptionHU: Any?,
    @SerializedName("strDescriptionIL")
    val strDescriptionIL: Any?,
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: Any?,
    @SerializedName("strDescriptionJP")
    val strDescriptionJP: Any?,
    @SerializedName("strDescriptionNL")
    val strDescriptionNL: Any?,
    @SerializedName("strDescriptionNO")
    val strDescriptionNO: Any?,
    @SerializedName("strDescriptionPL")
    val strDescriptionPL: Any?,
    @SerializedName("strDescriptionPT")
    val strDescriptionPT: Any?,
    @SerializedName("strDescriptionRU")
    val strDescriptionRU: Any?,
    @SerializedName("strDescriptionSE")
    val strDescriptionSE: Any?,
    @SerializedName("strGenre")
    val strGenre: String,
    @SerializedName("strLocked")
    val strLocked: String,
    @SerializedName("strMood")
    val strMood: Any?,
    @SerializedName("strMusicBrainzAlbumID")
    val strMusicBrainzAlbumID: String,
    @SerializedName("strMusicBrainzArtistID")
    val strMusicBrainzArtistID: String,
    @SerializedName("strMusicBrainzID")
    val strMusicBrainzID: String,
    @SerializedName("strMusicVid")
    val strMusicVid: String?,
    @SerializedName("strMusicVidCompany")
    val strMusicVidCompany: Any?,
    @SerializedName("strMusicVidDirector")
    val strMusicVidDirector: Any?,
    @SerializedName("strMusicVidScreen1")
    val strMusicVidScreen1: Any?,
    @SerializedName("strMusicVidScreen2")
    val strMusicVidScreen2: Any?,
    @SerializedName("strMusicVidScreen3")
    val strMusicVidScreen3: Any?,
    @SerializedName("strStyle")
    val strStyle: Any?,
    @SerializedName("strTheme")
    val strTheme: Any?,
    @SerializedName("strTrack")
    val strTrack: String,
    @SerializedName("strTrack3DCase")
    val strTrack3DCase: Any?,
    @SerializedName("strTrackLyrics")
    val strTrackLyrics: String?,
    @SerializedName("strTrackThumb")
    val strTrackThumb: Any?
)