package com.gg.movieapp.ui.trending

import com.gg.movieapp.base.BaseFragmentViewBinding
import com.gg.movieapp.data.model.Movie
import com.gg.movieapp.databinding.FragmentTrendingMovieBinding
import com.gg.movieapp.ui.trending.adapter.TrendingMovieAdapter
import com.gg.movieapp.utils.extension.hide
import com.gg.movieapp.utils.extension.show
import com.gg.movieapp.utils.onClick.OnItemRecyclerViewClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingFragment :
    BaseFragmentViewBinding<FragmentTrendingMovieBinding>(FragmentTrendingMovieBinding::inflate),
    OnItemRecyclerViewClickListener<Movie> {

    private val trendingViewModel: TrendingViewModel by viewModel()
    private val trendingAdapter by lazy { TrendingMovieAdapter() }

    private fun observerItem() {
        trendingViewModel.apply {
            moviesList.observe(viewLifecycleOwner) {
                trendingAdapter.submitList(it.results)
            }
            gettingTrendingMovies.observe(viewLifecycleOwner) {
                if (it) {
                    binding?.progressTrendingMovies?.show()
                } else {
                    binding?.progressTrendingMovies?.hide()
                }
            }
        }
    }

    override fun initView() {
        binding?.apply {
            recyclerTrendingMovies.adapter = trendingAdapter
        }
    }

    override fun initData() {
        trendingAdapter.setListener(this)
    }

    override fun bindData() {
        observerItem()
    }

    override fun onItemClick(item: Movie?) {
//        val bundle = bundleOf(Constant.BUNDLE_MOVIE to item)
//        findNavController().navigate(
//            R.id.action_homeFragment_to_playlistFragment,
//            bundle
//        )
    }

    override fun onItemLongClick(item: Movie?) {

    }
}