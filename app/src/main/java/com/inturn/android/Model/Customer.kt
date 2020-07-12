package com.inturn.android.Model

import com.inturn.android.Enum.CustomerStatus
import java.util.*

data class Customer(
    var id : String? = null,
    var firstName : String? = null,
    var lastName : String? = null,
    var email : String? = "",
    var customerStatus : CustomerStatus = CustomerStatus.registered
)