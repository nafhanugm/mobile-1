package com.nafhan.myapplication.network

import com.nafhan.myapplication.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users?page=2/")
    fun getAllUsers(): Call<Users>
}