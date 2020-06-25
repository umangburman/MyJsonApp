package com.mvvm.room.myjsonapp.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.room.myjsonapp.model.TableModel
import com.mvvm.room.myjsonapp.others.Connectivity
import com.mvvm.room.myjsonapp.repository.DetailsRepository

class DetailsViewModel : ViewModel() {

    lateinit var detailsLiveData: MutableLiveData<TableModel>

    lateinit var detailsRepository: DetailsRepository

    // Gets data from the API and Passes onto LiveData
    fun getDataFromApi(context: Context): MutableLiveData<TableModel> {

        detailsRepository = DetailsRepository()
        detailsLiveData = MutableLiveData()

        // Check for Internet Connectivity
        if (Connectivity.isOnline(context)) {
            detailsLiveData = detailsRepository.getDataFromApi(context, detailsLiveData)
        } else {
            detailsLiveData.value = null
        }

        return detailsLiveData
    }
}