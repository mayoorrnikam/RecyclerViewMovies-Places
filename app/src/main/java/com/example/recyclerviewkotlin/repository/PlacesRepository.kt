package com.example.recyclerviewkotlin.repository

import com.example.recyclerviewkotlin.models.PlaceModel

object PlacesRepository {

    private val placesList = ArrayList<PlaceModel>()

    fun getPlacesList() : List<PlaceModel>{
        if (placesList.isEmpty()) {
            var placeToAdd = PlaceModel("2015", "Mad Max: Fury Road", "Action & Adventure")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Inside Out", "Animation, Kids & Family")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Star Wars: Episode VII - The Force Awakens", "Action")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Shaun the Sheep", "Animation")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "The Martian", "Science Fiction & Fantasy")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Mission: Impossible Rogue Nation", "Action")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Up", "Animation")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Star Trek", "Science Fiction")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "The LEGO Place", "Animation")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Iron Man", "Action & Adventure")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Aliens", "Science Fiction")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Chicken Run", "Animation")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Back to the Future", "Science Fiction")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Raiders of the Lost Ark", "Action & Adventure")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Goldfinger", "Action & Adventure")
            placesList.add(placeToAdd)
            placeToAdd = PlaceModel("2015", "Guardians of the Galaxy", "Science Fiction & Fantasy")
            placesList.add(placeToAdd)
        }
        return placesList
    }

    fun addEntryToPlaces() : List<PlaceModel>{
        val placeToAdd = PlaceModel("2015", "Mayoorr Guardians of the Galaxy - ${placesList.size +1}", "Science Fiction & Fantasy")
        placesList.add(placeToAdd)
        return placesList
    }
}