package com.victorasj.wsprueba.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import basicDiffUtil
import com.victorasj.domain.Movie
import com.victorasj.wsprueba.R
import com.victorasj.wsprueba.databinding.MovieViewBinding
import inflate
import loadUrl

class MovieAdapter(val listener: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var movies : List<Movie> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent.inflate(
        R.layout.movie_view, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener(movie) }
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val binding = MovieViewBinding.bind(view)
        fun bind(movie : Movie) = with(binding){
            textViewTitle.text = movie.title
            movie.posterPath?.let { movieImage.loadUrl("https://image.tmdb.org/t/p/w185/${movie.posterPath}") }
        }
    }
}

