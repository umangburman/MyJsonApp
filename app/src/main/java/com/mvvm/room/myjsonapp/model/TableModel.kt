package com.mvvm.room.myjsonapp.model

import androidx.room.Entity

data class CanadaTableModel(

    val title: String? = null,
    val rows: String? = null
)

@Entity(tableName = "Details")
data class RowsData(

    val title: String? = null,
    val description: String? = null,
    val imageHref: String? = null
)