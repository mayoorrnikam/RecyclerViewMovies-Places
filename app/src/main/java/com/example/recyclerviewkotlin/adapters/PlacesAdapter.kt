package com.example.recyclerviewkotlin.adapters


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.PlaceDetailsActivity
import com.example.recyclerviewkotlin.R
import com.example.recyclerviewkotlin.models.PlaceModel

class PlacesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var places : List<PlaceModel> = ArrayList()

    class PlacesHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val imageView: ImageView = view.findViewById(R.id.display_image)
        private val placeTitle: TextView = view.findViewById(R.id.places_title)
        private val placeText: TextView = view.findViewById(R.id.places_text)

        fun bind(place : PlaceModel) {
//            imageView.background = (R.drawable.ic_launcher_foreground)
            placeTitle.text = place.placeTitle
            placeText.text = place.placeText
        }

    }

    fun submitPlacesList(placeList : List<PlaceModel>) {
        places = placeList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlacesHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.places_row, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is PlacesHolder -> {
                holder.bind(places[position])

                holder.itemView.setOnClickListener {
                    val intent = Intent(holder.itemView.context, PlaceDetailsActivity::class.java)
                    intent.putExtra("placeTitle", places[position].placeTitle)
                    intent.putExtra("placeText", places[position].placeText)

                    holder.itemView.context.startActivity(intent)
                }
            }
        }

    }

    override fun getItemCount(): Int {
       return places.size
    }

}