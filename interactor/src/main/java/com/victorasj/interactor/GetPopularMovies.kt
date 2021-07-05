package com.victorasj.interactor

import com.victorasj.data.repositories.MoviesRepository

class GetPopularMovies(private val moviesRepository: MoviesRepository) {
    suspend fun invoke() = moviesRepository.getPopularMovies()
}