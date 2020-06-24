package com.mvvm.room.myjsonapp.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.mvvm.room.myjsonapp.model.CanadaTableModel
import com.mvvm.room.myjsonapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CanadaDetailsRepository : Callback<CanadaTableModel> {

    lateinit var canadaDetailsLiveData: MutableLiveData<CanadaTableModel>

    fun getDataFromApi(context: Context) {

        val call = RetrofitClient.apiInterface
    }

    override fun onFailure(call: Call<CanadaTableModel>, t: Throwable) {
        // - - TODO("Not yet implemented")
        canadaDetailsLiveData.value = null
    }

    override fun onResponse(call: Call<CanadaTableModel>, response: Response<CanadaTableModel>) {
        // - - TODO("Not yet implemented")
        canadaDetailsLiveData.value = response.body()
    }
}