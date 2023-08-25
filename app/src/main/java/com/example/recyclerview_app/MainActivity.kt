package com.example.recyclerview_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerview_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesArrayList: ArrayList<Movies>
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val movie1 = Movies(1, "django", "Django", 14.99)
        val movie2 = Movies(2, "birzamanlaranadoluda", "Anadoluda", 10.99)
        val movie3 = Movies(3, "inception", "i=Inception", 9.99)
        val movie4 = Movies(4, "interstellar", "Interstellar", 14.99)
        val movie5 = Movies(5, "thehatefuleight", "The Hate Fuleight", 99.99)
        val movie6 = Movies(6, "thepianist", "The Pianist", 3.99)

        moviesArrayList = ArrayList<Movies>()
        moviesArrayList.add(movie1)
        moviesArrayList.add(movie2)
        moviesArrayList.add(movie3)
        moviesArrayList.add(movie4)
        moviesArrayList.add(movie5)
        moviesArrayList.add(movie6)

        adapter = MoviesAdapter(this@MainActivity, moviesArrayList)

        binding.rv.adapter = adapter

    }
}