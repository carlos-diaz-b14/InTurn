package com.inturn.android

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.inturn.android.Model.Restaurant

fun basicReadWrite() {
    // [START write_message]
    // Write a message to the database
    val database = Firebase.database
    /**this path just for test now*/
    val myRef = database.getReference("restaurant")

    val restaurant = Restaurant("1234 Richardson St, Vancouver",null,"Saku")
    val key = myRef.push().key.toString()
    myRef.child(key).setValue(restaurant)

//    myRef.setValue(restaurant)
    // [START read_message]
    // Read from the database
    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
//            val value = dataSnapshot.getValue<HashMap>()
            val restaurant: Restaurant? = dataSnapshot.getValue(Restaurant::class.java)
            Log.d(MainActivity.TAG,"${dataSnapshot.value}")
        }

        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(MainActivity.TAG, "Failed to read value.", error.toException())
        }
    })
    // [END read_message]
}