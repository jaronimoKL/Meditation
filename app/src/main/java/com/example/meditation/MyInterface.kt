package com.example.meditation

import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface MyInterface {
    @GET("/user/login")
    fun getAuth(@Body hashMap: HashMap<String,String>):retrofit2.Call<login>

    @GET("feelings")
    fun getFeel():retrofit2.Call<feelings>

    @GET("quotes")
    fun getQuotes():retrofit2.Call<quotes>
}