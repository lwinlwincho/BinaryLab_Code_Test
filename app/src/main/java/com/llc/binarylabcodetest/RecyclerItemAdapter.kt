package com.llc.binarylabcodetest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.llc.binarylabcodetest.databinding.RecyclerviewItemBinding
import com.llc.binarylabcodetest.extension.loadFromUrl
import com.llc.binarylabcodetest.model.GridViewModel
import com.llc.moviebd.R
import com.llc.moviebd.databinding.ItemPopularBinding
import com.llc.moviedb.data.model.MovieModel
import com.llc.moviedb.extension.loadFromUrl
import com.llc.moviedb.network.IMAGE_URL

class RecyclerItemAdapter(private val onItemClickListener: (GridViewModel) -> Unit) :
    ListAdapter<GridViewModel, RecyclerItemAdapter.PopularMovieViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        return PopularMovieViewHolder(
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val movieItem: GridViewModel = getItem(position)
        holder.bind(movieItem)
    }

    class PopularMovieViewHolder(
        private var binding: RecyclerviewItemBinding,
        private val onItemClickListener: (GridViewModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: GridViewModel) {

            with(binding) {
                ivPoster.loadFromUrl(IMAGE_URL + movieModel.posterPath)
                tvMovieName.text = movieModel.title
                tvStarRate.text = binding.root.context.getString(
                    R.string.vote_average_format,
                    movieModel.vote_average.toString()
                )

                root.setOnClickListener {
                    onItemClickListener.invoke(movieModel)
                }
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieModel>() {

        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
        }
    }
}