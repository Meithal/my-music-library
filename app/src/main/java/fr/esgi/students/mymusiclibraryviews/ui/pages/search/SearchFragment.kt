package fr.esgi.students.mymusiclibraryviews.ui.pages.search

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import fr.esgi.students.mymusiclibraryviews.R
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentSearchBinding
import fr.esgi.students.mymusiclibraryviews.ui.listings.albums.HitAlbumFragment
import fr.esgi.students.mymusiclibraryviews.ui.listings.hitsongs.MusicHitSongFragment
import fr.esgi.students.mymusiclibraryviews.ui.pages.rankings.HomeFragment


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[SearchViewModel::class.java].setText(
                requireActivity().resources.getString(R.string.most_loved_titles)
            )

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // val textView: TextView = binding

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = Bundle()
        args.putString("artist", "Coldplay")


        val sectionsPagerAdapter = HomeFragment.MyAdapter(childFragmentManager, resources)
        val viewPager: ViewPager = binding.viewPagerSearch
        viewPager.adapter = sectionsPagerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}