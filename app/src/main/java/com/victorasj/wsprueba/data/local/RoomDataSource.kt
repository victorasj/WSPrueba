package com.victorasj.wsprueba.data.local

import com.victorasj.data.sources.LocalDataSource
import com.victorasj.domain.Movie
import com.victorasj.wsprueba.toDomainMovie
import com.victorasj.wsprueba.toRoomMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db : MoviesDatabase) : LocalDataSource {

    val moviesDao = db.movieDao()

    override suspend fun isEmptyPopularMovies(): Boolean = withContext(Dispatchers.IO) { moviesDao.getCountMovies() <= 0 }

    override suspend fun getPopularMovies(): List<Movie> = withContext(Dispatchers.IO) { moviesDao.getPopularMovies().map { it.toDomainMovie() } }

    override suspend fun savePopularMovies(movies: List<Movie>) = withContext(Dispatchers.IO) { moviesDao.insertMovies(movies.map { it.toRoomMovie() }) }

    override suspend fun updateMovie(movie: Movie) = withContext(Dispatchers.IO) { moviesDao.updateMovie(movie.toRoomMovie()) }

    override suspend fun getFavouriteMovies(): List<Movie> = withContext(Dispatchers.IO) { moviesDao.getFavouriteMovies().map { it.toDomainMovie() } }

    override suspend fun getMovie(id: Int): Movie = withContext(Dispatchers.IO) { moviesDao.getMovie(id).toDomainMovie() }

    override suspend fun getSearchedMovies(keyword: String): List<Movie> = withContext(Dispatchers.IO) { moviesDao.getSearchedMovies(keyword).map { it.toDomainMovie() } }

}