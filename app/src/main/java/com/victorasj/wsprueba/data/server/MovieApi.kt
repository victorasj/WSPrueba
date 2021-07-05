package com.victorasj.wsprueba.data.server

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApi {

    // movie/popular
    @GET
    suspend fun getPopularMovies(@Url url : String, @Query("api_key") api_key : String) : MovieWrapper

}