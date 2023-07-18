package fr.esgi.students.mymusiclibraryviews.ui.rankings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.esgi.students.mymusiclibraryviews.NetworkManager
import fr.esgi.students.mymusiclibraryviews.R
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentRankingsBinding
import fr.esgi.students.mymusiclibraryviews.generateFakeLoved
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RankingsFragment : Fragment() {

    private var _binding: FragmentRankingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val data = MutableList(10) {
            generateFakeLoved()
        }
        data.addAll(data)
        data.addAll(data)

        val productsAdapter = ProductsAdapter(data, object :
            ProductsListFragment.OnProductClickListener {
            override fun onProductClicked(product: Product) {
                findNavController(ProductFragment).navigate()
            }
        })
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = productsAdapter

        GlobalScope.launch(Dispatchers.Main) {
            val product =  withContext(Dispatchers.Default) {
                val response = NetworkManager.getProduct("5000159484695")
                Log.println(Log.DEBUG, "Product", "Product Response:\n${response.response.toString()}")
            }
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_rankings, container, false)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}