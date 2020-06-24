package com.mvvm.room.myjsonapp.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.room.myjsonapp.model.TableModel
import com.mvvm.room.myjsonapp.repository.DetailsRepository

class DetailsViewModel : ViewModel() {

    lateinit var detailsLiveData: MutableLiveData<TableModel>

    lateinit var detailsRepository: DetailsRepository

    fun getDataFromApi(context: Context): MutableLiveData<TableModel> {

        detailsRepository = DetailsRepository()
        detailsLiveData = MutableLiveData()

        detailsLiveData = detailsRepository.getDataFromApi(context, detailsLiveData)

        return detailsLiveData
    }
}