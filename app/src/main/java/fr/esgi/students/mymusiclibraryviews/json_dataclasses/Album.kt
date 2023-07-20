package fr.esgi.students.mymusiclibraryviews.json_dataclasses
import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("idAlbum")
    val idAlbum: String,
    @SerializedName("idArtist")
    val idArtist: String,
    @SerializedName("idLabel")
    val idLabel: Any?,
    @SerializedName("intLoved")
    val intLoved: String,
    @SerializedName("intSales")
    val intSales: String,
    @SerializedName("intScore")
    val intScore: String,
    @SerializedName("intScoreVotes")
    val intScoreVotes: String,
    @SerializedName("intYearReleased")
    val intYearReleased: String,
    @SerializedName("strAlbum")
    val strAlbum: String,
    @SerializedName("strAlbum3DCase")
    val strAlbum3DCase: String,
    @SerializedName("strAlbum3DFace")
    val strAlbum3DFace: String,
    @SerializedName("strAlbum3DFlat")
    val strAlbum3DFlat: String,
    @SerializedName("strAlbum3DThumb")
    val strAlbum3DThumb: String,
    @SerializedName("strAlbumCDart")
    val strAlbumCDart: String,
    @SerializedName("strAlbumSpine")
    val strAlbumSpine: String,
    @SerializedName("strAlbumStripped")
    val strAlbumStripped: String,
    @SerializedName("strAlbumThumb")
    val strAlbumThumb: String,
    @SerializedName("strAlbumThumbBack")
    val strAlbumThumbBack: String,
    @SerializedName("strAlbumThumbHQ")
    val strAlbumThumbHQ: String,
    @SerializedName("strAllMusicID")
    val strAllMusicID: String,
    @SerializedName("strAmazonID")
    val strAmazonID: Any?,
    @SerializedName("strArtist")
    val strArtist: String,
    @SerializedName("strArtistStripped")
    val strArtistStripped: String,
    @SerializedName("strBBCReviewID")
    val strBBCReviewID: String,
    @SerializedName("strDescription")
    val strDescription: String,
    @SerializedName("strDescriptionCN")
    val strDescriptionCN: Any?,
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: String,
    @SerializedName("strDescriptionES")
    val strDescriptionES: String,
    @SerializedName("strDescriptionFR")
    val strDescriptionFR: String,
    @SerializedName("strDescriptionHU")
    val strDescriptionHU: Any?,
    @SerializedName("strDescriptionIL")
    val strDescriptionIL: Any?,
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: String,
    @SerializedName("strDescriptionJP")
    val strDescriptionJP: Any?,
    @SerializedName("strDescriptionNL")
    val strDescriptionNL: Any?,
    @SerializedName("strDescriptionNO")
    val strDescriptionNO: Any?,
    @SerializedName("strDescriptionPL")
    val strDescriptionPL: Any?,
    @SerializedName("strDescriptionPT")
    val strDescriptionPT: String,
    @SerializedName("strDescriptionRU")
    val strDescriptionRU: String,
    @SerializedName("strDescriptionSE")
    val strDescriptionSE: String,
    @SerializedName("strDiscogsID")
    val strDiscogsID: String,
    @SerializedName("strGeniusID")
    val strGeniusID: String,
    @SerializedName("strGenre")
    val strGenre: String,
    @SerializedName("strItunesID")
    val strItunesID: Any?,
    @SerializedName("strLabel")
    val strLabel: Any?,
    @SerializedName("strLocation")
    val strLocation: Any?,
    @SerializedName("strLocked")
    val strLocked: String,
    @SerializedName("strLyricWikiID")
    val strLyricWikiID: Any?,
    @SerializedName("strMood")
    val strMood: String,
    @SerializedName("strMusicBrainzArtistID")
    val strMusicBrainzArtistID: String,
    @SerializedName("strMusicBrainzID")
    val strMusicBrainzID: String,
    @SerializedName("strMusicMozID")
    val strMusicMozID: Any?,
    @SerializedName("strRateYourMusicID")
    val strRateYourMusicID: String,
    @SerializedName("strReleaseFormat")
    val strReleaseFormat: String,
    @SerializedName("strReview")
    val strReview: String,
    @SerializedName("strSpeed")
    val strSpeed: String,
    @SerializedName("strStyle")
    val strStyle: String,
    @SerializedName("strTheme")
    val strTheme: String,
    @SerializedName("strWikidataID")
    val strWikidataID: String,
    @SerializedName("strWikipediaID")
    val strWikipediaID: String
)