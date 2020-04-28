package com.example.coronacaseslivedata.apiservice

import com.example.coronacaseslivedata.jdo.CasesWrapper
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {

    @GET("summary")
    fun getCurrentCase(): Call<CasesWrapper>

    companion object {
        fun getApiService(): ApiService {
            var retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("https://api.covid19api.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}