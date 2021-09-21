package com.example.recyclerviewkotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewkotlin.models.PlaceModel
import com.example.recyclerviewkotlin.repository.PlacesRepository




class PlacesViewModel : ViewModel() {

    private val mPlacesList = MutableLiveData<List<PlaceModel>>()
    private var mIsPlaceAdded = MutableLiveData<Boolean>()
    private val placeRepository : PlacesRepository = PlacesRepository

    init {
        mPlacesList.value = placeRepository.getPlacesList()
    }


    fun getPlacesList() : LiveData<List<PlaceModel>> {
        return mPlacesList
    }

    fun addPlaces() {
        mIsPlaceAdded.value = false
        mPlacesList.value =  placeRepository.addEntryToPlaces()
        mIsPlaceAdded.value = true
    }

    fun getIsPlaceAdded() : LiveData<Boolean> {
        return mIsPlaceAdded
    }
}