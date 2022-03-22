package com.example.usbank.data

import retrofit2.Response
import retrofit2.http.GET

interface NumberService {
    @GET("integers/?num=1&min=1&max=100&col=1&base=10&format=plain&rnd=new")
    suspend fun getRandomNumber(): Response<Int>
}