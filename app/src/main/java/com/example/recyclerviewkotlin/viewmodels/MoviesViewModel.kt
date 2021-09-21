package com.example.recyclerviewkotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewkotlin.models.MovieModel
import com.example.recyclerviewkotlin.repository.MoviesRepository

class MoviesViewModel : ViewModel() {

    private val mMovieList =  MutableLiveData<List<MovieModel>>()
    private var mIsMovieAdded = MutableLiveData<Boolean>()
    private val mMovieRepository : MoviesRepository = MoviesRepository

    init {
        mMovieList.value = mMovieRepository.getMovieList()
    }

    fun getMovieList() : LiveData<List<MovieModel>> {
        return mMovieList
    }

    fun addMovie() {
        mIsMovieAdded.value = false
        mMovieList.value = mMovieRepository.addMovieToList()
        mIsMovieAdded.value = true
    }

    fun addMoviesList() : LiveData<Boolean> {
        return mIsMovieAdded
    }

}