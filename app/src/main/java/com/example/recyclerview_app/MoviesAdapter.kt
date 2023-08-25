package com.example.recyclerview_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val mContext: Context, private val listOfMovies: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.CardDesignObjectsClass>() {
    inner class CardDesignObjectsClass(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewMovie: ImageView
        var textViewMovieName: TextView
        var textViewMoviePrice: TextView
        var buttonAddToCard: Button

        init {
            imageViewMovie = view.findViewById(R.id.imageViewMovie)
            textViewMovieName = view.findViewById(R.id.textViewMovieName)
            textViewMoviePrice = view.findViewById(R.id.textViewMoviePrice)
            buttonAddToCard = view.findViewById(R.id.buttonAddToCard)
        }
    }

    override fun getItemCount(): Int = listOfMovies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignObjectsClass {
        val design =
            LayoutInflater.from(mContext).inflate(R.layout.card_movie_design, parent, false)
        return CardDesignObjectsClass(design)
    }

    override fun onBindViewHolder(holder: CardDesignObjectsClass, position: Int) {
        val movie = listOfMovies[position]

        holder.imageViewMovie.setImageResource(
            mContext.resources.getIdentifier(
                movie.movie_image_name,
                "drawable",
                mContext.packageName
            )
        )
        holder.textViewMovieName.text = movie.movie_name
        holder.textViewMoviePrice.text = "${movie.movie_price} AZN"
        holder.buttonAddToCard.setOnClickListener {
            Toast.makeText(mContext, "${movie.movie_name} added to card", Toast.LENGTH_SHORT).show()
        }
    }
}