package fr.esgi.students.mymusiclibraryviews.json_dataclasses


import com.google.gson.annotations.SerializedName

data class Loved(
    @SerializedName("idAlbum")
    val idAlbum: String,
    @SerializedName("idArtist")
    val idArtist: String,
    @SerializedName("idIMVDB")
    val idIMVDB: String?,
    @SerializedName("idLyric")
    val idLyric: String?,
    @SerializedName("idTrack")
    val idTrack: String,
    @SerializedName("intCD")
    val intCD: String?,
    @SerializedName("intDuration")
    val intDuration: String,
    @SerializedName("intLoved")
    val intLoved: String,
    @SerializedName("intMusicVidComments")
    val intMusicVidComments: String?,
    @SerializedName("intMusicVidDislikes")
    val intMusicVidDislikes: String?,
    @SerializedName("intMusicVidFavorites")
    val intMusicVidFavorites: String?,
    @SerializedName("intMusicVidLikes")
    val intMusicVidLikes: String?,
    @SerializedName("intMusicVidViews")
    val intMusicVidViews: String?,
    @SerializedName("intScore")
    val intScore: String,
    @SerializedName("intScoreVotes")
    val intScoreVotes: String,
    @SerializedName("intTotalListeners")
    val intTotalListeners: String,
    @SerializedName("intTotalPlays")
    val intTotalPlays: String,
    @SerializedName("intTrackNumber")
    val intTrackNumber: String,
    @SerializedName("strAlbum")
    val strAlbum: String,
    @SerializedName("strArtist")
    val strArtist: String,
    @SerializedName("strArtistAlternate")
    val strArtistAlternate: String?,
    @SerializedName("strDescription")
    val strDescription: String?,
    @SerializedName("strDescriptionCN")
    val strDescriptionCN: String?,
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: String?,
    @SerializedName("strDescriptionES")
    val strDescriptionES: Any?,
    @SerializedName("strDescriptionFR")
    val strDescriptionFR: String?,
    @SerializedName("strDescriptionHU")
    val strDescriptionHU: Any?,
    @SerializedName("strDescriptionIL")
    val strDescriptionIL: Any?,
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: String?,
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
    val strGenre: String?,
    @SerializedName("strLocked")
    val strLocked: String,
    @SerializedName("strMood")
    val strMood: String?,
    @SerializedName("strMusicBrainzAlbumID")
    val strMusicBrainzAlbumID: String,
    @SerializedName("strMusicBrainzArtistID")
    val strMusicBrainzArtistID: String,
    @SerializedName("strMusicBrainzID")
    val strMusicBrainzID: String,
    @SerializedName("strMusicVid")
    val strMusicVid: String?,
    @SerializedName("strMusicVidCompany")
    val strMusicVidCompany: String?,
    @SerializedName("strMusicVidDirector")
    val strMusicVidDirector: String?,
    @SerializedName("strMusicVidScreen1")
    val strMusicVidScreen1: String?,
    @SerializedName("strMusicVidScreen2")
    val strMusicVidScreen2: String?,
    @SerializedName("strMusicVidScreen3")
    val strMusicVidScreen3: String?,
    @SerializedName("strStyle")
    val strStyle: String?,
    @SerializedName("strTheme")
    val strTheme: String?,
    @SerializedName("strTrack")
    val strTrack: String,
    @SerializedName("strTrack3DCase")
    val strTrack3DCase: Any?,
    @SerializedName("strTrackLyrics")
    val strTrackLyrics: String?,
    @SerializedName("strTrackThumb")
    val strTrackThumb: String?
)