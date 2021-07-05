package com.victorasj.data.repositories

import com.victorasj.data.sources.LocalDataSource
import com.victorasj.data.sources.RemoteDataSource
import com.victorasj.domain.Movie

class MoviesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getPopularMovies() : List<Movie> {
        System.out.println("Peliculas en BBDD: " + localDataSource.isEmptyPopularMovies())
        if(localDataSource.isEmptyPopularMovies()){
            val movies = remoteDataSource.getPopularMovies()
            localDataSource.savePopularMovies(movies)
        }
        return localDataSource.getPopularMovies()
    }

    suspend fun getFavouriteMovies() : List<Movie> = localDataSource.getFavouriteMovies()

    suspend fun getSearchedMovies(keyword : String) : List<Movie> = localDataSource.getSearchedMovies(keyword)

    suspend fun updateMovie(movie : Movie) = localDataSource.updateMovie(movie)

    suspend fun getMovie(id : Int) : Movie = localDataSource.getMovie(id)
}