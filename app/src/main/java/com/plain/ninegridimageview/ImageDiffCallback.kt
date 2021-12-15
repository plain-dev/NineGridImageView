package com.plain.ninegridimageview

import androidx.recyclerview.widget.DiffUtil

class ImageDiffCallback : DiffUtil.ItemCallback<List<String>>() {

    override fun areItemsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
        return oldItem == newItem
    }

}