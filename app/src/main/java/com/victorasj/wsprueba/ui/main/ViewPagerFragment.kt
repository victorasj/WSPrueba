package com.victorasj.wsprueba.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.victorasj.wsprueba.SectionsPagerAdapter
import com.victorasj.wsprueba.databinding.ViewpagerFragmentBinding

class ViewPagerFragment : Fragment() {

    private lateinit var binding : ViewpagerFragmentBinding

    private lateinit var navController: NavController

    private lateinit var fragmentList: List<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewpagerFragmentBinding.inflate(layoutInflater)
        fragmentList = arrayListOf(PopularMoviesFragment(), FavouriteMoviesFragment())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), childFragmentManager, fragmentList)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }
}