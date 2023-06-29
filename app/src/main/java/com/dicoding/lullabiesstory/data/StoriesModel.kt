package com.dicoding.lullabiesstory.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class StoriesModel (
    var image: Int? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: String? = null,
    var genre: String? = null,
    var rate: String? = null,
    var readingtime: String? = null,
    var content: String? = null,
    var link: String? = null
) : Parcelable
