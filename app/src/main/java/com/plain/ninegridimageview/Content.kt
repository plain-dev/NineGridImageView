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

/*
    Tips

    使用正则匹配图片格式化参数 `&auto=format&fit=crop&w=1170&q=80`

    语法

        (?=&auto=format).*(?=")

        (?=A).*(?=B)

        解释：匹配 A 和 B 之间的内容，包含 A 不包含 B

    扩展

        &auto=format(.*?)"

        A(.*?)B

        解释：匹配 A 和 B 之间的内容，并且包含 A 和 B

    参考

        https://blog.csdn.net/zhangvalue/article/details/102786236

 */

private val images = mutableListOf(
    "https://images.unsplash.com/photo-1462007895615-c8c073bebcd8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1560840067-ddcaeb7831d2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1581321825690-944511645947?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1514439827219-9137a0b99245?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1550763347-0736ab2976ea?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1494488180300-4c634d1b2124?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1603929260784-262f38411fe4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1551641506-ee5bf4cb45f1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1513061379709-ef0cd1695189?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1525095240410-9645dea911e4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1516900557549-41557d405adf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1567320743368-9db24e12ebf0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1480374178950-b2c449be122e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
    "https://images.unsplash.com/photo-1536599018102-9f803c140fc1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000",
)

private val randomImages: List<String>
    get() {
        val temp = mutableListOf<String>()
        (0..(0..10).random()).forEach {
            temp.add(images[(0 until images.size).random()])
        }
        return temp
    }

val simpleContent: MutableList<List<String>>
    get() {
        val temp = mutableListOf<List<String>>()
        (0..(2..20).random()).forEach { _ ->
            temp.add(randomImages)
        }
        return temp
    }