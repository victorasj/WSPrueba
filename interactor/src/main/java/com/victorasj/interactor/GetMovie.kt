package com.victorasj.interactor

import com.victorasj.data.repositories.MoviesRepository

class GetMovie(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(id : Int) = moviesRepository.getMovie(id)
}