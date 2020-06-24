package com.mvvm.room.myjsonapp.retrofit

import com.mvvm.room.myjsonapp.model.CanadaTableModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getDetails(): Call<CanadaTableModel>
}