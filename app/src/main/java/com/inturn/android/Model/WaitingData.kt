package com.inturn.android.Model

import com.inturn.android.Enum.WaitingStatus
import java.util.*

data class WaitingData(
    var id : String? = null,
    /**The time when the customer click GET YOUR TABLE Button*/
    var checkTime : Date? = null,
    /**The time the table will available that estimated*/
    var expectedTime : Date? = null,
    var status : WaitingStatus = WaitingStatus.wating,
    var customer : Customer? = null,
    var people : Int? = null
)
