package com.example.apipractice.services

import com.example.apipractice.models.GameDeals
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {
    @GET("1.0/deals")
    fun getDeals(@Query("storeId") id:String, @Query("upperPrice") price:Int) : Call<List<GameDeals>>
}