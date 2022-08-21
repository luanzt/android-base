package com.gg.movieapp.utils.onClick

interface OnItemRecyclerViewClickListener<T> {
    fun onItemClick(item: T?)
    fun onItemLongClick(item: T?)
}
