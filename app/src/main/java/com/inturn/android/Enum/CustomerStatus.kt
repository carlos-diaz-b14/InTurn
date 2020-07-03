package com.inturn.android.Enum

/**For check customer status*/
enum class CustomerStatus(val code : Int) {
    registered(100),
    checked(200),
    deleted(300)
}