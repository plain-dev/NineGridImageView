/*
MIT License

Copyright (c) 2021 Plain

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

@file:Suppress("SetTextI18n")

package com.plain.ninegridimageview

import android.view.ViewGroup
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.plain.ninegridimageview.lib.GlideNineGridImageLoader
import com.plain.ninegridimageview.lib.NineGridImageView
import com.plain.ninegridimageview.lib.OnImageItemClickListener

class ImageAdapter(
    data: MutableList<List<String>>,
    private val onImageItemClickListener: OnImageItemClickListener
) : BaseQuickAdapter<List<String>, BaseViewHolder>(
    R.layout.layout_item_image,
    data
) {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return super.onCreateViewHolder(parent, viewType).apply {
            getView<NineGridImageView>(R.id.imageView).apply {
                imageLoader = GlideNineGridImageLoader()
                onImageItemClickListener = this@ImageAdapter.onImageItemClickListener
            }
        }
    }

    override fun convert(holder: BaseViewHolder, item: List<String>) {
        holder.getView<TextView>(R.id.tvInfo).text = """
            bindingAdapterPosition: ${holder.bindingAdapterPosition}
            absoluteAdapterPosition: ${holder.absoluteAdapterPosition}
            layoutPosition: ${holder.layoutPosition}

            image size ${item.size}
        """.trimIndent()
        holder.getView<NineGridImageView>(R.id.imageView).apply {
            externalPosition = holder.bindingAdapterPosition
            setUrlList(item)
        }
    }

}