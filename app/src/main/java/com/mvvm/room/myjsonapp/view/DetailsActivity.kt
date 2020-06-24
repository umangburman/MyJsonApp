package com.mvvm.room.myjsonapp.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mvvm.room.myjsonapp.R
import com.mvvm.room.myjsonapp.viewmodel.DetailsViewModel

class DetailsActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        context = this@DetailsActivity

        detailsViewModel = ViewModelProvider(this)
            .get(DetailsViewModel::class.java)


    }
}