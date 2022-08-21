package com.gg.movieapp.ui.trending.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gg.movieapp.data.model.Movie
import com.gg.movieapp.databinding.ItemTrendingMovieBinding
import com.gg.movieapp.utils.Constant
import com.gg.movieapp.utils.extension.loadImageWithUrl
import com.gg.movieapp.utils.onClick.OnItemRecyclerViewClickListener

class TrendingMovieAdapter :
    ListAdapter<Movie, TrendingMovieAdapter.ViewHolder>(Movie.diffCallback) {

    private var listener: OnItemRecyclerViewClickListener<Movie>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTrendingMovieBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setListener(listener: OnItemRecyclerViewClickListener<Movie>) {
        this.listener = listener
    }

    class ViewHolder(
        private val binding: ItemTrendingMovieBinding,
        private val listener: OnItemRecyclerViewClickListener<Movie>?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                tvOverview.text = movie.overview
                tvName.text = movie.title ?: movie.name
                tvRating.text = buildString {
                    append("Rating: ")
                    append(movie.vote_average)
                }
                ivMovie.loadImageWithUrl(Constant.IMAGE_URL + movie.poster_path)
                root.setOnClickListener {
                    listener?.onItemClick(movie)
                }
            }
        }
    }
}

