package com.example.usbank.data

import android.content.res.Resources
import android.util.Log
import java.lang.Exception

object NumberRepository {
    suspend fun getRandomNumber(): Result<Int> {
        return try {
            val result = RetrofitInstance.numberService.getRandomNumber()
            if (result.isSuccessful && result.body() != null) {
                Result.success(result.body()!!)
            } else {
                Result.failure(Resources.NotFoundException("No result"))
            }
        } catch (ex: Exception) {
            Log.d(NumberRepository::class.java.name, ex.message ?: "unexpected error")
            Result.failure(ex)
        }
    }
}