package com.teddy.traffictrackerdemo.network

import retrofit2.http.GET

interface MockyIOService {
    @GET("5e86edbe3100006d97814e5c")
    suspend fun get() : String
}