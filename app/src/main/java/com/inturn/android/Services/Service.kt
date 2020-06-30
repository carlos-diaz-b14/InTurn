package com.inturn.android.Services

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

fun getData(path: String, getSuccessFunction:(getData:DataSnapshot)->Unit, getErrorFunction:(error:DatabaseError)-> Unit){
    val database = Firebase.database
    val myRef = database.getReference(path)

    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            getSuccessFunction(dataSnapshot)
        }

        override fun onCancelled(error: DatabaseError) {
            getErrorFunction(error)
        }
    })
}

fun postData(path : String, data : Any, postSuccessFunction:(getData:DataSnapshot)->Unit, postErrorFunction:(error:DatabaseError)-> Unit){
    val database = Firebase.database
    val myRef = database.getReference(path)

    val key = myRef.push().key.toString()
    myRef.child(key).setValue(data)

    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            postSuccessFunction(dataSnapshot)
        }

        override fun onCancelled(error: DatabaseError) {
            postErrorFunction(error)
        }
    })
}

fun updateData(path : String, data : Any, updateSuccessFunction:(getData:DataSnapshot)->Unit, updateErrorFunction:(error:DatabaseError)-> Unit){
    val database = Firebase.database
    val myRef = database.getReference(path)
    myRef.setValue(data)

    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            updateSuccessFunction(dataSnapshot)
        }

        override fun onCancelled(error: DatabaseError) {
            updateErrorFunction(error)
        }
    })
}


