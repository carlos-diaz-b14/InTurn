package com.inturn.android.Model

data class Restaurant(
    var id : String? = null,
    var name : String? = null,
    var address: String? = null,
    var wating : List<getWaitingData>? = null
)