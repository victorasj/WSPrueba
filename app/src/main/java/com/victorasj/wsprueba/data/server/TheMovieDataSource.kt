package com.victorasj.wsprueba.data.server

import android.content.Context
import android.util.Log
import com.victorasj.data.sources.RemoteDataSource
import com.victorasj.domain.Movie
import com.victorasj.wsprueba.R
import com.victorasj.wsprueba.toDomainMovie

class TheMovieDataSource(context: Context) : RemoteDataSource {

    private val apiKey = context.getString(R.string.api_key)

    override suspend fun getPopularMovies(): List<Movie> {
        val moviesList = RetrofitInstance.SERVICE.getPopularMovies("movie/popular", apiKey).results.map { it.toDomainMovie() }
        Log.d("Peliculas", moviesList.toString())
        return moviesList
    }



}