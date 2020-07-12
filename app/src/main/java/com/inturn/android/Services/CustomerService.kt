package com.inturn.android.Services

import com.inturn.android.Model.Customer

fun getCustomerByEmailService(email:String, success:(customer : Customer?)->Unit, error:(error:Any?)->Unit){
    getData("customer",{
        val restaurants: MutableList<Customer> = mutableListOf()
        var customer : Customer? = null
        it.children.forEach{
            if (it.child("email").getValue(String::class.java).equals(email)) {
                customer = it.getValue(Customer::class.java)!!
                customer?.id = it.key
                return@forEach
            }
        }

        /**if that customer data not exist here will pass null*/
        success(customer)
    },{
        error(error)
    })
}

fun postCustomerService(customerData: Customer, success:(customer : Customer)->Unit, error:(error:Any?)->Unit){
    getData("customer",{
        val restaurants: MutableList<Customer> = mutableListOf()
        var customer : Customer? = null
        it.children.forEach{
            if (it.child("email").getValue(String::class.java).equals(customerData.email)) {
                customer = it.getValue(Customer::class.java)!!
                customer?.id = it.key
                return@forEach
            }
        }

        /**if already exist don't post*/
        if(customer == null){
            postData("customer", customerData,
                {
                    customer = it.getValue(Customer::class.java)!!
                    customer?.id = it.key
                    success(customer!!)
                },

                {
                    error(error)
                })
        }

    },{
        error(error)
    })
}