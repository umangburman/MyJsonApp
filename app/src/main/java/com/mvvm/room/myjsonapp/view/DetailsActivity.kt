package com.mvvm.room.myjsonapp.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvvm.room.myjsonapp.R
import com.mvvm.room.myjsonapp.model.RowsData
import com.mvvm.room.myjsonapp.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var detailsViewModel: DetailsViewModel

    lateinit var detailsList: List<RowsData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        context = this@DetailsActivity

        setSupportActionBar(toolbar)
        supportActionBar.apply {
            title = "- - -"
        }

        detailsViewModel = ViewModelProvider(this)
            .get(DetailsViewModel::class.java)

        detailsViewModel.getDataFromApi(context).observe(this, Observer {

            supportActionBar.apply {
                title = it.title
            }


        })
    }
}