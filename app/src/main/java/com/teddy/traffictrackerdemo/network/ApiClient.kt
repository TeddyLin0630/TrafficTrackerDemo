package com.teddy.traffictrackerdemo.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiClient {
    val mockyIOService: MockyIOService by lazy {
        val httpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(OkHttpProfilerInterceptor())
            .build()
        Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(MockyIOService::class.java)
    }

    companion object {
        private var apiClient: ApiClient? = null

        fun getInstance() =
            apiClient ?: synchronized(this) {
                apiClient ?: ApiClient().also { apiClient = it }
            }
    }
}