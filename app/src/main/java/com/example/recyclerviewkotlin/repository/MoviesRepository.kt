package com.example.recyclerviewkotlin.repository

import com.example.recyclerviewkotlin.models.MovieModel

object MoviesRepository {
    private val movieList = ArrayList<MovieModel>()

    fun getMovieList()  : ArrayList<MovieModel>{
        if(movieList.isEmpty()) {
            var movie = MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015")
            movieList.add(movie)
            movie = MovieModel("Inside Out", "Animation, Kids & Family", "2015")
            movieList.add(movie)
            movie = MovieModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
            movieList.add(movie)
            movie = MovieModel("Shaun the Sheep", "Animation", "2015")
            movieList.add(movie)
            movie = MovieModel("The Martian", "Science Fiction & Fantasy", "2015")
            movieList.add(movie)
            movie = MovieModel("Mission: Impossible Rogue Nation", "Action", "2015")
            movieList.add(movie)
            movie = MovieModel("Up", "Animation", "2009")
            movieList.add(movie)
            movie = MovieModel("Star Trek", "Science Fiction", "2009")
            movieList.add(movie)
            movie = MovieModel("The LEGO MovieModel", "Animation", "2014")
            movieList.add(movie)
            movie = MovieModel("Iron Man", "Action & Adventure", "2008")
            movieList.add(movie)
            movie = MovieModel("Aliens", "Science Fiction", "1986")
            movieList.add(movie)
            movie = MovieModel("Chicken Run", "Animation", "2000")
            movieList.add(movie)
            movie = MovieModel("Back to the Future", "Science Fiction", "1985")
            movieList.add(movie)
            movie = MovieModel("Raiders of the Lost Ark", "Action & Adventure", "1981")
            movieList.add(movie)
            movie = MovieModel("Goldfinger", "Action & Adventure", "1965")
            movieList.add(movie)
            movie = MovieModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
            movieList.add(movie)
        }
        return movieList
    }

    fun addMovieToList() : ArrayList<MovieModel> {
        val movie = MovieModel("Guardians of the Galaxy", "Mayoorr - Science Fiction & Fantasy- ${movieList.size}", "2014")
        movieList.add(movie)
        return movieList
    }

}