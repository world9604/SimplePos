package com.example.remote.model

import com.example.data.model.CategoryEntity
import com.example.data.model.MenuItemEntity
import com.example.remote.Constant
import com.example.remote.RemoteMapper
import com.google.gson.annotations.SerializedName
import java.util.Date

data class SummaryMovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val name: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val posterImagePath: String,
    @SerializedName("vote_average")
    val rating: Float,
    @SerializedName("vote_count")
    val rateCount: Int,
    @SerializedName("release_date")
    val releasedAt: Date,
) : RemoteMapper<MenuItemEntity> {

    private val posterImageUrl: String
        get() = Constant.POSTER_IMAGE_PREFIX_URL + posterImagePath

    override fun toData(): MenuItemEntity =
        MenuItemEntity(
            id = id,
            name = name,
            quantity = 1,
            imageUrl = posterImageUrl,
            price = 1000,
            category = CategoryEntity.COFFEE)
}
