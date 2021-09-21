package com.example.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewkotlin.databinding.ActivityPlaceDetailsBinding

class PlaceDetailsActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityPlaceDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_place_details)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.place_details)
        actionBar.setDisplayHomeAsUpEnabled(true)

        binding = ActivityPlaceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentContent()

    }

    private fun getIntentContent(){
        val placeTitle = intent?.getStringExtra("placeTitle")
        val placeText = intent?.getStringExtra("placeText")

        setContent(placeTitle, placeText)
    }

    private fun setContent(placeTitle: String?, placeText: String?) {
        binding.placeDetailsTitle.text = placeTitle
        binding.placeDetailsText.text = placeText
    }
}