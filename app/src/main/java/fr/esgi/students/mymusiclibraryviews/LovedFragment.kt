package fr.esgi.students.mymusiclibraryviews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch

class LovedFragment: Fragment() {

    private val model: LovedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.activity_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // val format = LovedFragmentArgs.fromBundle(requireArguments()).format
        model.findLovedList(LovedFormat.album)



        lifecycleScope.launch {
            model.lovedFlow.collect { loved ->
                if (loved != null) {
                    //view.findViewById<TextView>(R.id.format).text = loved.format
                    Glide.with(this@LovedFragment).load("https://cataas.com/cat")
                        .into(view.findViewById<ImageView>(R.id.food_details))
                }
            }
        }

    }

}