package com.example.remote.model

import com.google.gson.annotations.SerializedName

data class SummaryMovieWrapperResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val summaryMovies: List<SummaryMovieResponse>,
)
