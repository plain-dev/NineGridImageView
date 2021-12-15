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

package com.plain.ninegridimageview

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.plain.ninegridimageview.databinding.ActivityMainBinding
import com.plain.ninegridimageview.lib.NineGridImageView
import com.plain.ninegridimageview.lib.OnImageItemClickListener

class MainActivity : AppCompatActivity(), OnImageItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private val data = mutableListOf<List<String>>()

    private val imageAdapter = ImageAdapter(data, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.contentList.apply {
            setHasFixedSize(true)
            imageAdapter.setDiffCallback(ImageDiffCallback())
            adapter = imageAdapter
            addItemDecoration(
                MaterialDividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                ).apply {
                    dividerColor = Color.parseColor("#f3f3f3")
                }
            )
        }

        binding.refreshButton.setOnClickListener {
            loadData()
        }

        loadData()
    }

    private fun loadData() {
        imageAdapter.setDiffNewData(simpleContent)
    }

    override fun onClick(
        nineGridView: NineGridImageView,
        imageView: ImageView,
        url: String,
        urlList: List<String>,
        externalPosition: Int,
        position: Int
    ) {
        val info = """
            externalPosition $externalPosition
            position $position
        """.trimIndent()
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show()
    }

}