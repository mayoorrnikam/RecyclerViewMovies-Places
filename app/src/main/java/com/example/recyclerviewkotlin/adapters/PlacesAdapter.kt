package com.example.recyclerviewkotlin.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.R
import com.example.recyclerviewkotlin.models.PlaceModel

class PlacesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var places : List<PlaceModel> = ArrayList()
    private lateinit var onPlacesClickListener: PlacesHolder.OnPlacesClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlacesHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.places_row, parent, false), onPlacesClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is PlacesHolder -> {
                holder.bind(places[position])
            }
        }

    }

    override fun getItemCount(): Int {
       return places.size
    }

    fun submitPlacesList(placeList : List<PlaceModel>?) {
        if (placeList != null) {
            places = placeList
        }
    }

    fun submitOnPlacesClick(placesClickListener: PlacesHolder.OnPlacesClickListener) {
        onPlacesClickListener = placesClickListener
    }

    class PlacesHolder(
        private var view: View,
        var onPlacesClickListener: OnPlacesClickListener
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {

//        val imageView: ImageView = view.findViewById(R.id.display_image)
        private val placeTitle: TextView = view.findViewById(R.id.places_title)
        private val placeText: TextView = view.findViewById(R.id.places_text)

        fun bind(place : PlaceModel) {
//            imageView.background = (R.drawable.ic_launcher_foreground)
            placeTitle.text = place.placeTitle
            placeText.text = place.placeText

            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onPlacesClickListener.onPlacesClick(adapterPosition)
        }

        interface OnPlacesClickListener {
            fun onPlacesClick(position: Int)
        }

    }

}