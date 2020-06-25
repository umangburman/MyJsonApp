package com.mvvm.room.myjsonapp.model


data class TableModel(

    val title: String? = null,
    val rows: List<RowsData>? = null
)

data class RowsData(

    val title: String? = null,
    val description: String? = null,
    val imageHref: String? = null

)