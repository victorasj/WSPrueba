package com.victorasj.wsprueba.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.victorasj.wsprueba.R
import com.victorasj.wsprueba.databinding.ActivityNavHostBinding
import com.victorasj.wsprueba.databinding.SplashFragmentBinding
import com.victorasj.wsprueba.databinding.ViewpagerFragmentBinding

class SplashFragment : Fragment() {

    private lateinit var binding: SplashFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashFragmentBinding.inflate(layoutInflater)
        Handler().postDelayed({
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToViewPagerFragment())
        }, 1000 )
        return binding.root
    }

}