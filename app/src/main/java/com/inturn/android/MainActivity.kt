package com.inturn.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inturn.android.Model.Restaurant
import com.inturn.android.Services.basicReadWrite
import com.inturn.android.Services.getAllRestaurant

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "KotlinActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllRestaurant({success(it)}, {fail{it}})
    }

    fun success(restaurant : List<Restaurant>?) {
        print(restaurant)
    }

    fun fail(error : Any?){

    }

}
