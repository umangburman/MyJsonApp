package com.mvvm.room.myjsonapp.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mvvm.room.myjsonapp.R
import com.mvvm.room.myjsonapp.viewmodel.CanadaDetailsViewModel

class CanadaDetailsActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var canadaDetailsViewModel: CanadaDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canadadetails)

        context = this@CanadaDetailsActivity

        canadaDetailsViewModel = ViewModelProvider(this)
            .get(CanadaDetailsViewModel::class.java)


    }
}