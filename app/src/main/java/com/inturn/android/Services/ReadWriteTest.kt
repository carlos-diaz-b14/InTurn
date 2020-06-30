package com.inturn.android.Services

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.inturn.android.MainActivity
import com.inturn.android.Model.Customer
import com.inturn.android.Model.Restaurant

fun basicReadWrite() {
    val database = Firebase.database
    /**this path just for test now*/
    val myRef = database.getReference("customer")

//    val restaurant = Restaurant("1234 Richardson St, Vancouver",null,"Saku")
    val customer = Customer(firstName = "Aaron", lastName = "Chen", email = "aaron@test.com")
    val key = myRef.push().key.toString()

//    myRef.child(key).setValue(restaurant)
     myRef.child(key).setValue(customer)

//    myRef.addValueEventListener(object : ValueEventListener {
//        override fun onDataChange(dataSnapshot: DataSnapshot) {
//            val restaurant: Restaurant? = dataSnapshot.getValue(Restaurant::class.java)
//            Log.d(MainActivity.TAG,"${dataSnapshot.value}")
//        }
//
//        override fun onCancelled(error: DatabaseError) {
//            Log.w(MainActivity.TAG, "Failed to read value.", error.toException())
//        }
//    })
}