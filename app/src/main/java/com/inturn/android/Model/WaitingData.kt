package com.inturn.android.Model

import java.util.*

data class getWaitingData(
    var id : String? = null,
    /**The time when the customer click GET YOUR TABLE Button*/
    var checkTime : Date? = null,
    /**The time the table will available that estimated*/
    var expectedTime : Date? = null,
    var status : WaitingStatus = WaitingStatus.wating,
    var customer : Customer,
    var people : Int
)