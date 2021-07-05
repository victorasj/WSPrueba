package com.victorasj.wsprueba.ui.main

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.victorasj.wsprueba.EventObserver
import com.victorasj.wsprueba.databinding.PopularMoviesFragmentBinding
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : ScopeFragment() {


    private lateinit var binding : PopularMoviesFragmentBinding

    private lateinit var adapter: MovieAdapter

    private lateinit var navController: NavController

    private val viewModel: PopularMoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PopularMoviesFragmentBinding.inflate(layoutInflater)
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
            navController.navigate(PopularMoviesFragmentDirections.actionPopularMoviesFragmentToDetailFragment(it.id))
        })

        binding.searchViewMovies.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(value: String): Boolean {
                viewModel.search(value)
                return false
            }
            override fun onQueryTextSubmit(value: String): Boolean {
                return true
            }
        })
    }



    private fun updateUi(model : PopularMoviesViewModel.UiModel) {
        binding.progress.visibility = if(model is PopularMoviesViewModel.UiModel.Loading) View.VISIBLE else View.GONE
        when(model) {
            is PopularMoviesViewModel.UiModel.Content -> adapter.movies = model.movies
        }
    }


}