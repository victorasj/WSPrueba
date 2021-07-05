package com.victorasj.wsprueba.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.victorasj.wsprueba.EventObserver
import com.victorasj.wsprueba.databinding.FavouriteMoviesFragmentBinding
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouriteMoviesFragment : ScopeFragment() {

    private lateinit var binding : FavouriteMoviesFragmentBinding

    private lateinit var adapter: MovieAdapter

    private lateinit var navController: NavController

    private val viewModel: FavouriteMoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FavouriteMoviesFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        adapter = MovieAdapter (viewModel::onMovieClick)
        binding.recyclerViewMovies.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewMovies.adapter = adapter
        viewModel.model.observe(viewLifecycleOwner, Observer (::updateUi))
        viewModel.navigateToMovie.observe(viewLifecycleOwner, EventObserver {
            navController.navigate(FavouriteMoviesFragmentDirections.actionFavouriteMoviesFragmentToDetailFragment(it.id))
        })
    }

    private fun updateUi(model : FavouriteMoviesViewModel.UiModel) {
        binding.progress.visibility = if(model is FavouriteMoviesViewModel.UiModel.Loading) View.VISIBLE else View.GONE
        when(model) {
            is FavouriteMoviesViewModel.UiModel.Content -> adapter.movies = model.movies
        }
    }

}