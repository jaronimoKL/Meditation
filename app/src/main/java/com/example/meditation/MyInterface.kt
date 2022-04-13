package com.example.meditation

import retrofit2.http.GET

interface MyInterface {
    @GET("feelings")
    fun postLogin() : retrofit2.Call<feelings>

    @GET("quotes")
    fun getQuotes() : retrofit2.Call<quotes>
}