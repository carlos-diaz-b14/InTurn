package com.inturn.android.Model

import com.google.firebase.database.DataSnapshot

data class Restaurant(
    var id : String? = null,
    var name : String? = null,
    var address: String? = null,
    var wating : MutableList<WaitingData> = mutableListOf()
)

data class getRestaurant(
    var id : String? = null,
    var name : String? = null,
    var address: String? = null,
    var watingList : MutableList<WaitingData> = mutableListOf()
)