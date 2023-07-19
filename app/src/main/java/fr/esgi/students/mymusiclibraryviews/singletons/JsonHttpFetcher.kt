package fr.esgi.students.mymusiclibraryviews.singletons

import android.content.Context
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

class JsonHttpFetcher {

    companion object {
        fun fetch(url: String, context: Context, onRes : Response.Listener<JSONObject>, onErr: Response.ErrorListener) {

            Toast.makeText(context, "Starting a volley request", Toast.LENGTH_SHORT).show()
            
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                onRes,
                onErr
            )

            jsonObjectRequest.retryPolicy = DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            )

            // Access the RequestQueue through your singleton class.
            VolleyQueue.getInstance(context=context).addToRequestQueue(jsonObjectRequest)
        }
    }
}