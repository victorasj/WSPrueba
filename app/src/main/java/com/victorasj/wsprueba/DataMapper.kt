package com.victorasj.wsprueba

import com.victorasj.wsprueba.data.server.Movie as ServerMovie
import com.victorasj.wsprueba.data.local.Movie as RoomMovie
import com.victorasj.domain.Movie as DomainMovie


fun DomainMovie.toRoomMovie() : RoomMovie =
    RoomMovie(
        id,
        title,
        overview,
        releaseDate = "a",
        posterPath,
        backdropPath = "",
        originalLanguage,
        originalTitle,
        popularity = Double.MIN_VALUE,
        voteAverage,
        favourite
    )

fun RoomMovie.toDomainMovie() : DomainMovie =
    DomainMovie(
        id,
        title,
        overview,
        releaseDate,
        posterPath,
        backdropPath,
        originalLanguage,
        originalTitle,
        popularity,
        voteAverage,
        favourite
    )

fun ServerMovie.toRoomMovie() : RoomMovie =
    RoomMovie(
        id,
        title,
        overview,
        releaseDate!!,
        posterPath,
        backdropPath!!,
        originalLanguage,
        originalTitle,
        popularity!!,
        voteAverage,
        false
    )

fun ServerMovie.toDomainMovie() : DomainMovie = DomainMovie(id, title, overview, releaseDate, posterPath, backdropPath, originalLanguage, originalTitle, popularity, voteAverage, false)