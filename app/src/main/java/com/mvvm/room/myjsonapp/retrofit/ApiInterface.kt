package com.mvvm.room.myjsonapp.retrofit

import com.mvvm.room.myjsonapp.model.TableModel
import retrofit2.Call
import retrofit2.http.GET

// Used for Retrofit API Calls
interface ApiInterface {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getDetails(): Call<TableModel>
}