package com.example.flixter

import org.json.JSONArray

data class Movie (
    val movieID: Int,
    private val posterPath: String, // Made private since we don't ever actually need to use it
    val title: String,
    val overview: String,
) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath" // This was hard-coded from the hints page
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}