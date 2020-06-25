package com.mvvm.room.myjsonapp.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.mvvm.room.myjsonapp.model.RowsData
import com.mvvm.room.myjsonapp.model.TableModel
import com.mvvm.room.myjsonapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsRepository : Callback<TableModel> {

    lateinit var detailsLiveData: MutableLiveData<TableModel>

    lateinit var detailsTableList: ArrayList<RowsData>

    fun getDataFromApi(context: Context, liveData: MutableLiveData<TableModel>)
            : MutableLiveData<TableModel> {

        detailsLiveData = liveData
        detailsTableList = ArrayList()

        val call = RetrofitClient.apiInterface.getDetails()
        call.enqueue(this)

        return detailsLiveData
    }

    override fun onFailure(call: Call<TableModel>, t: Throwable) {
        // - - TODO("Not yet implemented")
        detailsLiveData.value = null
    }

    override fun onResponse(call: Call<TableModel>, response: Response<TableModel>) {
        // - - TODO("Not yet implemented")
        detailsLiveData.value = response.body()
    }
}