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

class DetailsAdapter constructor(val context: Context, val userList: List<RowsData>) :
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

        holder.lblTitle.text = detailsData.title?.let { it -> "- - -" }
        holder.lblDescription.text = detailsData.description?.let { it -> "- - -" }

        val url = detailsData.imageHref
        Glide.with(context)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_no_image_found)
            .into(holder.imgReference)
    }

    override fun getItemCount(): Int = userList.size
}