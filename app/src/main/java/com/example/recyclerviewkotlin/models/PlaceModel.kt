package com.example.recyclerviewkotlin.models

import java.io.Serializable

data class PlaceModel(
    val placeImage: String,
    val placeTitle: String,
    val placeText: String
) : Serializable
