package com.example.recyclerviewkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewkotlin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    /**
     * Depending on the name of the Activity the automatic class is created while using the view-binding
     * e.g.
     * HomeActivity -> ActivityHomeBinding
     * MainActivity -> ActivityMainBinding
     * SearchActivity -> ActivitySearchBinding
     */

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.home)

        binding.showPlacesButton.setOnClickListener {
            showPlaces()
        }

        binding.showMoviesButton.setOnClickListener {
            showMovies()
        }
    }


    private fun showMovies() {
        val intent = Intent(this@HomeActivity, MoviesActivity::class.java)
        startActivity(intent)

    }

    private fun showPlaces() {
        startActivity(Intent(this@HomeActivity, PlacesActivity::class.java))

    }

}