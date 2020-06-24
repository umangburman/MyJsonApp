package com.mvvm.room.myjsonapp.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.room.myjsonapp.model.CanadaTableModel
import com.mvvm.room.myjsonapp.repository.DetailsRepository

class DetailsViewModel : ViewModel() {

    lateinit var detailsLiveData: MutableLiveData<CanadaTableModel>

    lateinit var detailsRepository: DetailsRepository

    fun getDataFromApi(context: Context): MutableLiveData<CanadaTableModel> {

        detailsRepository = DetailsRepository()
        detailsLiveData = MutableLiveData()

        detailsLiveData = detailsRepository.getDataFromApi(context, detailsLiveData)

        return detailsLiveData
    }
}