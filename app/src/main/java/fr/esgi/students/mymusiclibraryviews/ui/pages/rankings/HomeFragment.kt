package fr.esgi.students.mymusiclibraryviews.ui.pages.rankings

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
import fr.esgi.students.mymusiclibraryviews.databinding.FragmentRankingBinding
import fr.esgi.students.mymusiclibraryviews.ui.listings.albums.HitAlbumFragment
import fr.esgi.students.mymusiclibraryviews.ui.listings.hitsongs.MusicHitSongFragment


class HomeFragment : Fragment() {

    private var _binding: FragmentRankingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java].setText(
                requireActivity().resources.getString(R.string.rankings_title)
            )

        _binding = FragmentRankingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = Bundle()
        args.putString("artist", "Coldplay")


        val sectionsPagerAdapter = MyAdapter(childFragmentManager, resources)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabLayoutHome
        tabs.setupWithViewPager(viewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class MyAdapter(fm: FragmentManager, val res: Resources) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when(position) {
                0 -> res.getString(R.string.tab_top_songs_title)
                1 -> res.getString(R.string.tab_top_albums_title)
                else -> res.getString(R.string.tab_top_songs_title)
            }
        }
        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 -> MusicHitSongFragment.newInstance(1)
                1 -> HitAlbumFragment.newInstance(2)
                else -> MusicHitSongFragment.newInstance(1)
            }
        }
    }

}