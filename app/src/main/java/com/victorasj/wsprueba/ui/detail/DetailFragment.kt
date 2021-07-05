package com.victorasj.wsprueba.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.victorasj.dxcprueba.ui.detail.DetailViewModel
import com.victorasj.wsprueba.R
import com.victorasj.wsprueba.databinding.DetailFragmentBinding
import loadUrl
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : ScopeFragment() {

    private lateinit var binding : DetailFragmentBinding

    private val args : DetailFragmentArgs by navArgs()

    private val viewModel: DetailViewModel by viewModel { parametersOf(args.id) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.model.observe(viewLifecycleOwner, Observer (::UpdateUI))
        binding.movieDetailFavorite.setOnClickListener { viewModel.onFavoriteClicked() }
    }

    private fun UpdateUI(model : DetailViewModel.UiModel){
        with(binding) {
            movieDetailImage.loadUrl("https://image.tmdb.org/t/p/w185/${model.movie.posterPath}")
            movieDetailToolbar.title = model.movie.title
            movieDetailSummary.text = model.movie.overview
            movieDetailInfo.setMovie(model.movie)
            val icon = if (model.movie.favourite) R.drawable.ic_favorite_on else R.drawable.ic_favorite_off
            movieDetailFavorite.setImageDrawable(ContextCompat.getDrawable(requireContext(), icon)
            )
        }
    }

}