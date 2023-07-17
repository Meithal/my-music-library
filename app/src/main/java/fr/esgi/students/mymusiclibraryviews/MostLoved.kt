package fr.esgi.students.mymusiclibraryviews

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class MostLoved(
    val loved: List<Loved>
)

data class Loved(
    val idAlbum: String,
    val idArtist: String,
    val idLabel: String,
    val intLoved: String,
    val intSales: String,
    val intScore: String,
    val intScoreVotes: String,
    val intYearReleased: String,
    val strAlbum: String,
    val strAlbum3DCase: String,
    val strAlbum3DFace: String,
    val strAlbum3DFlat: String,
    val strAlbum3DThumb: String,
    val strAlbumCDart: String,
    val strAlbumSpine: String,
    val strAlbumStripped: String,
    val strAlbumThumb: String,
    val strAlbumThumbBack: String,
    val strAlbumThumbHQ: String,
    val strAllMusicID: String,
    val strAmazonID: Any,
    val strArtist: String,
    val strArtistStripped: String,
    val strBBCReviewID: String,
    val strDescription: String,
    val strDescriptionCN: Any,
    val strDescriptionDE: String,
    val strDescriptionES: String,
    val strDescriptionFR: String,
    val strDescriptionHU: String,
    val strDescriptionIL: Any,
    val strDescriptionIT: String,
    val strDescriptionJP: String,
    val strDescriptionNL: String,
    val strDescriptionNO: String,
    val strDescriptionPL: String,
    val strDescriptionPT: String,
    val strDescriptionRU: String,
    val strDescriptionSE: String,
    val strDiscogsID: String,
    val strGeniusID: String,
    val strGenre: String,
    val strItunesID: Any,
    val strLabel: String,
    val strLocation: Any,
    val strLocked: String,
    val strLyricWikiID: Any,
    val strMood: String,
    val strMusicBrainzArtistID: String,
    val strMusicBrainzID: String,
    val strMusicMozID: String,
    val strRateYourMusicID: String,
    val strReleaseFormat: String,
    val strReview: String,
    val strSpeed: String,
    val strStyle: String,
    val strTheme: String,
    val strWikidataID: String,
    val strWikipediaID: String
)

enum class LovedFormat(val format: String) {
    album("album"), track("track")
}

// https://theaudiodb.com/api/v1/json/523532/mostloved.php?format=album
interface API {
    @GET("/mostloved.php")
    fun getMostLovedListAsync(
        @Query("format") format: LovedFormat,
    ): Deferred<MostLoved>
}

object NetworkManager {

    private val api = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(API::class.java)

    suspend fun getMostLovedList(format: LovedFormat): List<Loved> {
        return api.getMostLovedListAsync(format).await().loved
    }

}
