package com.mvvm.room.myjsonapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvm.room.myjsonapp.R
import com.mvvm.room.myjsonapp.model.RowsData
import kotlinx.android.synthetic.main.list_item_details.view.*

class DetailsAdapter constructor(val context: Context, val userList: ArrayList<RowsData>) :
    RecyclerView.Adapter<DetailsAdapter.DetailsHolder>() {

    class DetailsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var lblTitle = itemView.lblTitleAnswer
        var lblDescription = itemView.lblDescriptionAnswer
        var imgReference = itemView.imgHref
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_details, parent, false)

        return DetailsHolder(view)
    }

    override fun onBindViewHolder(holder: DetailsHolder, position: Int) {

        val detailsData: RowsData = userList.get(position)

        if (!detailsData.title.isNullOrBlank())
            holder.lblTitle.text = detailsData.title else holder.lblTitle.visibility = View.GONE
        if (!detailsData.description.isNullOrEmpty())
            holder.lblDescription.text = detailsData.description
        else holder.lblDescription.visibility = View.GONE

        if (!detailsData.imageHref.isNullOrEmpty()) {
            val url = detailsData.imageHref
            Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_no_image_found)
                .into(holder.imgReference)
        } else holder.imgReference.visibility = View.GONE
    }

    override fun getItemCount(): Int = userList.size
}