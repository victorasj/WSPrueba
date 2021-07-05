package com.victorasj.wsprueba.data.server

import com.google.gson.annotations.SerializedName

data class MovieWrapper (
    val page: Int,
    val results: List<Movie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int

)
