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

private val images = mutableListOf(
    "https://www.apple.com.cn/mac/home/images/overview/holiday-2021/aos_hol21_mac_family_hero__gjmygt9ehwuq_large.jpg",
    "https://www.apple.com.cn/v/macbook-pro-14-and-16/b/images/overview/performance/screen_processing__f36dk3ge7wey_large.jpg",
    "https://www.apple.com.cn/v/macbook-pro-14-and-16/b/images/overview/performance/graphics_screen_endframe__bin7avhv5lci_large.jpg",
    "https://www.apple.com.cn/v/macbook-pro-14-and-16/b/images/overview/display/screen_xdr__fksbj0zqvtu2_large.jpg",
    "https://www.apple.com.cn/macos/monterey/images/overview/shortcuts_app__c3iufw18cfsm_large.png",
    "https://www.apple.com.cn/macos/monterey/images/overview/icloud_hide_email__ezxbu9j7gscy_large.png",
    "https://www.apple.com.cn/macos/monterey/images/overview/even_more__fdvcgx80tx6y_large.jpg",
    "https://www.apple.com.cn/v/ipad-pro/ah/images/overview/experience/intro_chip_static__q0mhvwtkh8qe_large.jpg",
    "https://www.apple.com.cn//v/ipad-pro/ah/images/overview/experience/intro_display_static__d19ubvnynzma_large.jpg",
    "https://www.apple.com.cn/v/ipad-pro/ah/images/overview/experience/intro_5g_static__f8hdfylmpfu6_large.jpg",
    "https://www.apple.com.cn/ipad-pro/images/overview/chip/m1_hero__d6vadsyfqbgy_large.jpg",
    "https://www.apple.com.cn/ipad-pro/images/overview/display-liquid-retina/liquid_retina_endframe__e22htc2zu0cy_large.jpg",
    "https://www.apple.com.cn/v/ipad-pro/ah/images/overview/cameras/cameras_rear__crhh6catjtme_large.jpg",
    "https://www.apple.com.cn/ipad-pro/images/overview/thunderbolt/thunderbolt_hero__fg7vx8fb8ve6_large.jpg",
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