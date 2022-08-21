package com.gg.movieapp.data.model

import androidx.recyclerview.widget.DiffUtil
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val poster_path: String? = null,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val genre_ids: List<String>,
    val id: Int,
    val origin_title: String,
    val original_language: String,
    val title: String? = null,
    val name: String,
    val backdrop_path: String? = null,
    val popularity: Float,
    val vote_count: Int,
    val video: Boolean,
    val vote_average: Float,
) : Parcelable {
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}


