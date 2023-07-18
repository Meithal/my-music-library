package fr.esgi.students.mymusiclibraryviews

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

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

    suspend fun getLovedList(format: LovedFormat): List<Loved> {
        return api.getMostLovedListAsync(format).await().loved
    }

}