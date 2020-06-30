package com.inturn.android.Services

import com.inturn.android.Model.Restaurant


fun getRestaurant(restaurantId:String, success:(restaurant: Restaurant?)->Unit, error:(error:Any?)->Unit){
    getData(restaurantId,
        {
        val restaurant: Restaurant? = it.getValue(Restaurant::class.java)
        success(restaurant)
    },

        {
        error(error)
    })
}

fun getAllRestaurant(success: (restaurant: List<Restaurant>?) -> Unit, error:(error:Any?) -> Unit){
    getData("restaurant",
        {
            val restaurants: MutableList<Restaurant> = mutableListOf()

            it.children.forEach{
                restaurants.add(it.getValue(Restaurant::class.java)!!)
            }

            success(restaurants)
        },

        {
            error(error)
        })
}

