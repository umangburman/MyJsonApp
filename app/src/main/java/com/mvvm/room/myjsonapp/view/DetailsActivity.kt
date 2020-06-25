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
import com.mvvm.room.myjsonapp.model.RowsData
import com.mvvm.room.myjsonapp.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var detailsViewModel: DetailsViewModel

    var detailsList: ArrayList<RowsData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        context = this@DetailsActivity

        detailsList = ArrayList()

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

                if (detailsList == null) {
                    recyclerView.visibility = View.GONE
                    noDataConstraint.visibility = View.VISIBLE
                } else {

                    for (items in tableModel.rows!!) {
                        if (!items.title.isNullOrBlank() &&
                            !items.description.isNullOrBlank() &&
                            !items.imageHref.isNullOrBlank()
                        ) {
                            detailsList!!.add(items)
                        }
                    }

                    val detailsAdapter = DetailsAdapter(context, detailsList!!)
                    recyclerView.apply {
                        adapter = detailsAdapter
                    }
                }
            }

        })
    }
}