package com.mvvm.room.myjsonapp.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.room.myjsonapp.R
import com.mvvm.room.myjsonapp.adapter.DetailsAdapter
import com.mvvm.room.myjsonapp.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        context = this@DetailsActivity

        setSupportActionBar(toolbar)
        supportActionBar.apply {
            title = "- - -"
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        detailsViewModel = ViewModelProvider(this)
            .get(DetailsViewModel::class.java)

        detailsViewModel.getDataFromApi(context).observe(this, Observer { tableModel ->

            if (tableModel == null) {
                recyclerView.visibility = View.GONE
                noDataConstraint.visibility = View.VISIBLE
            } else {

                supportActionBar.apply {
                    title = tableModel.title
                }

                val detailsAdapter = tableModel.rows?.let { it -> DetailsAdapter(context, it) }
                recyclerView.apply {
                    adapter = detailsAdapter
                }
            }

        })
    }
}