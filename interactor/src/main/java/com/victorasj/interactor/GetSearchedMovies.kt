package com.victorasj.interactor

import com.victorasj.data.repositories.MoviesRepository

class GetSearchedMovies(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(keyword : String) = moviesRepository.getSearchedMovies(keyword)
}