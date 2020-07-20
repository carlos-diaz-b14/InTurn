package com.inturn.android.model

import com.inturn.android.Enum.CustomerStatus

data class Customer(
    var id : String? = null,
    var firstName : String? = null,
    var lastName : String? = null,
    var email : String? = "",
    var customerStatus : CustomerStatus = CustomerStatus.registered
)