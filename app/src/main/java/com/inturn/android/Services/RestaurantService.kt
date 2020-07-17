package com.inturn.android.Services

import com.google.firebase.database.DataSnapshot
import com.inturn.android.Enum.WaitingStatus
import com.inturn.android.Model.Restaurant
import com.inturn.android.Model.WaitingData
import com.inturn.android.Model.getRestaurant

fun getRestaurant(restaurantId:String, success:(restaurant: DataSnapshot)->Unit, error:(error:Any?)->Unit){
    getData("restaurant/" + restaurantId, success, error)


//    getData("restaurant/" + restaurantId,
//        {
//        val restaurant: Restaurant? = it.getValue(Restaurant::class.java)
//        success(restaurant)
//    },
//        {
//        error(error)
//    })
}

fun getAllRestaurant(success: (restaurant: DataSnapshot) -> Unit, error:(error:Any?) -> Unit){
    getData("restaurant", success, error)
//    getData("restaurant",
//        {
//            val restaurants: MutableList<getRestaurant> = mutableListOf()
//
//            it.children.forEach{
//                var restaurant = it.getValue(getRestaurant::class.java)!!
//                restaurant.id = it.key
//
//                it.child("wating").children.forEach{
//                    restaurant.watingList.add(it.getValue(WaitingData::class.java)!!)
//                }
//                restaurants.add(restaurant)
//            }
//
//            success(restaurants)
//        },
//
//        {
//            error(error)
//        })
}

fun addQueueInRestaurant(restaurantId: String, waitingData: WaitingData, success: (restaurant: DataSnapshot) -> Unit, error:(error:Any?) -> Unit){
    postData("restaurant/" + restaurantId + "/wating", waitingData, success, error)
//    postData("restaurant/" + restaurantId + "/wating", waitingData, success,
//        {
//            error(error)
//        }
//    )
}




fun addNewRestaurant(restaurant: Restaurant, success: (restaurant: DataSnapshot) -> Unit, error:(error:Any?) -> Unit){
    postData("restaurant", restaurant, success, error)
//    postData("restaurant", restaurant,
//        {
//
//        },
//        {
//
//        }
//    )
}

fun updateWaitingDataWaitingStatus(restaurantId: String, waitingDataId :String, status:WaitingStatus, success: (restaurant: DataSnapshot) -> Unit, error:(error:Any?) -> Unit){

    updateData("restaurant/" + restaurantId + "/wating/" + waitingDataId + "/status", status, success, error)

//    updateData("restaurant/" + restaurantId + "/wating/" + waitingDataId + "/status", status,
//        {
////            var waitingData = it.getValue(WaitingData::class.java)!!
//           print(it.key)
////            success(waitingData)
//        },
//        {
//            error(error)
//        }
//    )
}

