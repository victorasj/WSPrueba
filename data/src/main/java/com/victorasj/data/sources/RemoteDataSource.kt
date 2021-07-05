package com.victorasj.data.sources

import com.victorasj.domain.Movie

interface RemoteDataSource {
    suspend fun getPopularMovies() :  List<Movie>
}