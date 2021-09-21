package com.example.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewkotlin.adapters.MoviesAdapter
import com.example.recyclerviewkotlin.adapters.PlacesAdapter
import com.example.recyclerviewkotlin.databinding.ActivityMoviesBinding
import com.example.recyclerviewkotlin.repository.MoviesRepository
import com.example.recyclerviewkotlin.viewmodels.MoviesViewModel

class MoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.movies_list)
        actionBar.setDisplayHomeAsUpEnabled(true)


        moviesViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MoviesViewModel::class.java)


        moviesViewModel.getMovieList().observe(this, Observer {
            moviesAdapter.notifyDataSetChanged()
        })


        moviesViewModel.addMoviesList().observe(this, Observer {
            moviesAdapter.notifyDataSetChanged()

            binding.moviesRecyclerView.smoothScrollToPosition(moviesAdapter.itemCount-1)
        })

        binding.floatingActionMovieButton.setOnClickListener {
            moviesViewModel.addMovie()
        }

        initializeMoviesRecyclerView()
        initPlaces()
    }


    private fun initializeMoviesRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this@MoviesActivity)
        binding.moviesRecyclerView.layoutManager = linearLayoutManager
        moviesAdapter = MoviesAdapter()
        binding.moviesRecyclerView.adapter = moviesAdapter
    }
    private fun initMoviesRecyclerViewApply() {
        binding.moviesRecyclerView.apply {
            linearLayoutManager = LinearLayoutManager(this@MoviesActivity)
            layoutManager = linearLayoutManager
            moviesAdapter = MoviesAdapter()
            adapter = moviesAdapter
        }
    }

    private fun initPlaces() {
        moviesViewModel.getMovieList().value?.let {
            moviesAdapter.submitMovieList(it)
        }
    }


}