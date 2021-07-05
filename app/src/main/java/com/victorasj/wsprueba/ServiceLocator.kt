package com.victorasj.wsprueba

import android.app.Application
import com.victorasj.data.repositories.MoviesRepository
import com.victorasj.data.sources.LocalDataSource
import com.victorasj.data.sources.RemoteDataSource
import com.victorasj.dxcprueba.ui.detail.DetailViewModel
import com.victorasj.interactor.*
import com.victorasj.wsprueba.data.local.MoviesDatabase
import com.victorasj.wsprueba.data.local.RoomDataSource
import com.victorasj.wsprueba.data.server.TheMovieDataSource
import com.victorasj.wsprueba.ui.detail.DetailFragment
import com.victorasj.wsprueba.ui.main.FavouriteMoviesFragment
import com.victorasj.wsprueba.ui.main.FavouriteMoviesViewModel
import com.victorasj.wsprueba.ui.main.PopularMoviesFragment
import com.victorasj.wsprueba.ui.main.PopularMoviesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initServiceLocator(){
    startKoin {
        androidLogger()
        androidContext(this@initServiceLocator)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    single { MoviesDatabase.build(get()) }
    factory<RemoteDataSource> { TheMovieDataSource(get()) }
    factory<LocalDataSource> { RoomDataSource(get()) }
}

private val dataModule = module {
    factory { MoviesRepository(get(), get()) }
}

private val scopesModule = module {
    scope(named<PopularMoviesFragment>()){
        viewModel { PopularMoviesViewModel(get(), get()) }
        scoped { GetPopularMovies(get()) }
        scoped { GetSearchedMovies(get()) }
    }

    scope(named<FavouriteMoviesFragment>()){
        viewModel { FavouriteMoviesViewModel(get()) }
        scoped { GetFavouriteMovies(get()) }
    }

    scope(named<DetailFragment>()){
        viewModel { (id : Int) -> DetailViewModel(get(), get(),  id) }
        scoped { GetMovie(get()) }
        scoped { ToggleMovieFavourite(get()) }
    }

}
