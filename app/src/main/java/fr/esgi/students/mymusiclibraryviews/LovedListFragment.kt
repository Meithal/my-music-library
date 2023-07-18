package fr.esgi.students.mymusiclibraryviews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LovedsListFragment : Fragment() {

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = view.findViewById<RecyclerView>(R.id.list)
            val data =
                  mutableListOf(
                     generateFakeLoved(),
                      generateFakeLoved(),
                      generateFakeLoved(),
                      generateFakeLoved(),
                      generateFakeLoved(),
                  )

        val lovedsAdapter = LovedsAdapter(data, object : OnLovedClickListener {
            override fun onLovedClicked(loved: Loved) {
            /*    view.findNavController().navigate(
                    LovedsListFragmentDirections.actionLovedsListFragmentToLovedFragment(
                        loved.idAlbum
                    )
                )

             */
            }
        })

        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = lovedsAdapter


    }
}