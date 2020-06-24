package com.mvvm.room.myjsonapp.model

import androidx.room.Entity

data class TableModel(

    val title: String? = null,
    val rows: List<RowsData>? = null
)

@Entity(tableName = "Details")
data class RowsData(

    val title: String? = null,
    val description: String? = null,
    val imageHref: String? = null
)