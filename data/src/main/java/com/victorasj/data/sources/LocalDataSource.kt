package com.victorasj.data.sources

import com.victorasj.domain.Movie

interface LocalDataSource {
    suspend fun isEmptyPopularMovies() :  Boolean
    suspend fun getPopularMovies() :  List<Movie>
    suspend fun savePopularMovies(movies : List<Movie>)
    suspend fun updateMovie(movie : Movie)
    suspend fun getFavouriteMovies() :  List<Movie>
    suspend fun getMovie(id : Int) : Movie
    suspend fun getSearchedMovies(keyword : String) :  List<Movie>

}