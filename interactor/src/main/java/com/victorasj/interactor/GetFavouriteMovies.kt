package com.victorasj.interactor

import com.victorasj.data.repositories.MoviesRepository

class GetFavouriteMovies(private val moviesRepository: MoviesRepository) {
    suspend fun invoke() = moviesRepository.getFavouriteMovies()
}