package com.victorasj.wsprueba.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.victorasj.domain.Movie
import com.victorasj.dxcprueba.common.ScopedViewModel
import com.victorasj.interactor.GetFavouriteMovies
import com.victorasj.wsprueba.Event
import kotlinx.coroutines.launch

class FavouriteMoviesViewModel(private val getFavouriteMovies: GetFavouriteMovies) : ScopedViewModel() {
    sealed class UiModel {
        object Loading : UiModel()
        class Content(val movies : List<Movie>) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model : LiveData<UiModel>
        get() {
            if(_model.value == null) refresh()
            return _model
        }


    private val _navigateToMovie = MutableLiveData<Event<Movie>>()
    val navigateToMovie: LiveData<Event<Movie>> get() = _navigateToMovie


    private fun refresh() {
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getFavouriteMovies.invoke())
        }
    }

    fun onMovieClick(movie: Movie) {
        _navigateToMovie.value = Event(movie)
    }

}