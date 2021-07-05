package com.victorasj.dxcprueba.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.victorasj.domain.Movie
import com.victorasj.dxcprueba.common.ScopedViewModel
import com.victorasj.interactor.GetMovie
import com.victorasj.interactor.ToggleMovieFavourite
import kotlinx.coroutines.launch

class DetailViewModel(private val getMovie : GetMovie, private val toogleFavouriteMovie: ToggleMovieFavourite, private val id : Int) : ScopedViewModel() {

    data class UiModel(val movie: Movie)
    
    private val _model = MutableLiveData<UiModel>()
    val model : LiveData<UiModel>
        get() {
            if(_model.value == null) loadMovie(id)
            return _model
        }

    private fun loadMovie(id : Int){
        launch {
            _model.value = UiModel(getMovie.invoke(id))
        }
    }

    fun onFavoriteClicked() = launch {
        _model.value?.movie?.let {
            _model.value = UiModel(toogleFavouriteMovie.invoke(it))
        }
    }

}