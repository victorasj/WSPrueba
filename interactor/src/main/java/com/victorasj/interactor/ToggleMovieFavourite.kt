package com.victorasj.interactor

import com.victorasj.data.repositories.MoviesRepository
import com.victorasj.domain.Movie

class ToggleMovieFavourite (private val moviesRepository: MoviesRepository) {
    suspend fun invoke(movie: Movie): Movie = with(movie) {
        copy(favourite = !favourite).also { moviesRepository.updateMovie(it) }
    }}