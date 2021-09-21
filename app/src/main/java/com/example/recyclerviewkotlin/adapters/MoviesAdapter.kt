package com.example.recyclerviewkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.R
import com.example.recyclerviewkotlin.models.MovieModel

class MoviesAdapter () : RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    private var movies : List<MovieModel> = ArrayList()

    class MovieHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val movieTitle : TextView  = view.findViewById(R.id.movie_title)
        private val movieGenres : TextView  = view.findViewById(R.id.movie_genres)
        private val movieReleaseYear : TextView  = view.findViewById(R.id.movie_release_year)

        fun bind(movie: MovieModel) {
            movieTitle.text = movie.movieTitle
            movieGenres.text = movie.movieGenres
            movieReleaseYear.text = movie.movieReleaseYear
        }
    }


    fun submitMovieList(moviesList: List<MovieModel>){
        movies = moviesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_row, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MovieHolder -> {
                holder.bind(movies[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}