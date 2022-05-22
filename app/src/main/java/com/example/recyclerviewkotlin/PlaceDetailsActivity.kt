package com.example.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewkotlin.databinding.ActivityPlaceDetailsBinding
import com.example.recyclerviewkotlin.models.PlaceModel

class PlaceDetailsActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityPlaceDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.place_details)
        actionBar.setDisplayHomeAsUpEnabled(true)

        binding = ActivityPlaceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentContent()

    }

    private fun getIntentContent(){
        val placeListPosition = intent?.getStringExtra("placeListPosition")
        val placeModelBySerializableExtra = intent?.getSerializableExtra("PlaceModel") as PlaceModel
        val placeModel = intent?.extras?.getSerializable("PlaceModel") as PlaceModel
        setContent(placeModelBySerializableExtra, placeModel, placeListPosition)
    }

    private fun setContent(
        placeModel: PlaceModel?,
        placeModelBySerializableExtra : PlaceModel?,
        placeListPosition : String?
    ) {
        binding.placeDetailsTitle.text = placeModelBySerializableExtra?.placeTitle
        binding.placeDetailsText.text = placeModel?.placeText
        binding.placeListPositionText.text = "Place List Position: $placeListPosition"
    }
}