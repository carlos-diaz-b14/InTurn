package com.inturn.android.Services

import com.inturn.android.Enum.WaitingStatus
import com.inturn.android.Model.Restaurant
import com.inturn.android.Model.WaitingData
import com.inturn.android.Model.getRestaurant

fun getRestaurant(restaurantId:String, success:(restaurant: Restaurant?)->Unit, error:(error:Any?)->Unit){
    getData("restaurant/" + restaurantId,
        {
        val restaurant: Restaurant? = it.getValue(Restaurant::class.java)
        success(restaurant)
    },
        {
        error(error)
    })
}

fun getAllRestaurant(success: (restaurant: List<getRestaurant>?) -> Unit, error:(error:Any?) -> Unit){
    getData("restaurant",
        {
            val restaurants: MutableList<getRestaurant> = mutableListOf()

            it.children.forEach{
                var restaurant = it.getValue(getRestaurant::class.java)!!
                restaurant.id = it.key

                it.child("wating").children.forEach{
                    restaurant.watingList.add(it.getValue(WaitingData::class.java)!!)
                }
                restaurants.add(restaurant)
            }

            success(restaurants)
        },

        {
            error(error)
        })
}

fun addQueueInRestaurant(restaurantId: String, waitingData: WaitingData, success: (restaurant: WaitingData) -> Unit, error:(error:Any?) -> Unit){
    postData("restaurant/" + restaurantId + "/wating", waitingData,
        {
            var waitingData = it.getValue(WaitingData::class.java)!!
            waitingData.id = it.key
            success(waitingData)
        },
        {
            error(error)
        }
    )
}

fun addNewRestaurant(restaurant: Restaurant, success: (restaurant: Restaurant) -> Unit, error:(error:Any?) -> Unit){
    postData("restaurant", restaurant,
        {

        },
        {

        }
    )
}

fun updateWaitingDataWaitingStatus(restaurantId: String, waitingDataId :String, status:WaitingStatus, success: (restaurant: Restaurant) -> Unit, error:(error:Any?) -> Unit){
    updateData("restaurant/" + restaurantId + "/wating/" + waitingDataId + "/status", status,
        {
//            var waitingData = it.getValue(WaitingData::class.java)!!
           print(it.key)
//            success(waitingData)
        },
        {
            error(error)
        }
    )
}

