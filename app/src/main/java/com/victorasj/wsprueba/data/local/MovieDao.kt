package com.victorasj.wsprueba.data.local

import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT COUNT(id) FROM movies")
    fun getCountMovies() : Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movies : List<Movie>)

    @Query("SELECT * FROM movies")
    fun getPopularMovies() : List<Movie>

    @Query("SELECT * FROM movies WHERE favourite = 1")
    fun getFavouriteMovies() : List<Movie>

    @Query("SELECT * FROM movies WHERE title LIKE '%'|| :keyword ||'%'")
    fun getSearchedMovies(keyword : String) : List<Movie>

    @Update
    fun updateMovie(movie : Movie)

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovie(id : Int) : Movie

}