package com.example.socialapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val Base_URL = "https://newsapi.org/"
const val API_Key = "293c7869cff6476983c74c0c7b83a3e9"

interface NewsInterface{
    @GET("/v2/top-headlines?apiKey$API_Key")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int) : Call<News>
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}