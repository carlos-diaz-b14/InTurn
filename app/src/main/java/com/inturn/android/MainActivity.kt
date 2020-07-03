package com.inturn.android

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.inturn.android.Enum.WaitingStatus
import com.inturn.android.Model.Customer
import com.inturn.android.Model.Restaurant
import com.inturn.android.Model.WaitingData
import com.inturn.android.Model.getRestaurant
import com.inturn.android.Services.*
import java.time.LocalDateTime
import java.time.ZoneId

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "KotlinActivity"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**add NewRestaurant example*/
//        val restaurant = Restaurant(null, "Saku", "1234 Richardson St, Vancouver", mutableListOf())
//        addNewRestaurant(restaurant,{},{})

        /**add new customer example*/
//        val userdata = Customer(firstName = "firstName", lastName = "lastName", email = "name2@test.com")
//        postCustomerService(userdata ,{}, {fail{it}})

        /**add waiting data to restaurant example*/
//        val userdata = Customer(firstName = "firstName", lastName = "lastName", email = "name2@test.com")
//        val waitingData = WaitingData(null, java.util.Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()), java.util.Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())
//        ,WaitingStatus.wating, userdata, 3)
//        addQueueInRestaurant("-MBAe66mDPPlynlus4-e", waitingData, {}, {})

        /**get all restaurant example*/
//        getAllRestaurant({success(it)},{fail(it)})

        /**update waiting status*/
//        updateWaitingDataWaitingStatus("-MBAe66mDPPlynlus4-e", "-MBBM00tsewixNETcr0x", WaitingStatus.wating, {}, {})
    }

    /**when success call this function*/
//    fun success(cdata:List<getRestaurant>?) {
//        print(cdata)
//    }

    /**when fail call this function*/
//    fun fail(error : Any?){
//
//    }

}
