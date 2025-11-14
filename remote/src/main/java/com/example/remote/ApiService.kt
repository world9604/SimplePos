package com.example.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.remote.model.SummaryMovieWrapperResponse

interface ApiService {
    @GET("discover/movie?&sort_by=popularity.desc")
    suspend fun getSummaryMovies(
        @Query("language") language: String,
        @Query("region") country: String,
    ): SummaryMovieWrapperResponse

    @GET("movie/{movieId}/recommendations")
    suspend fun getRecommendMovies(
        @Path("movieId") movieId: Int,
        @Query("language") language: String,
    ): SummaryMovieWrapperResponse

    @GET("movie/{movieId}/similar")
    suspend fun getSimilarMovies(
        @Path("movieId") movieId: Int,
        @Query("language") language: String,
    ): SummaryMovieWrapperResponse

}
