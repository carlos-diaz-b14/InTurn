package com.inturn.android.viewmodel

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inturn.android.Enum.WaitingStatus
import com.inturn.android.Model.Customer
import com.inturn.android.Model.WaitingData
import com.inturn.android.Services.addQueueInRestaurant
import com.inturn.android.Services.postCustomerService
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class MainViewModel : ViewModel() {

    private val _getTableData = MutableLiveData<WaitingData>()
    val getTableData: LiveData<WaitingData>
        get() = _getTableData


    private val _firstName = MutableLiveData<String>()

    val firstName: MutableLiveData<String>
        get() = _firstName


    private val _lastName = MutableLiveData<String>()

    val lastName: MutableLiveData<String>
        get() = _lastName

    private val _email = MutableLiveData<String>()

    val email: MutableLiveData<String>
        get() = _email


    private val _people = MutableLiveData<String>()

    val people: MutableLiveData<String>
        get() = _people

    private val _isgetTableBtnEnable = MutableLiveData<Boolean>()
    val isgetTableBtnEnable: LiveData<Boolean>
        get() = _isgetTableBtnEnable

    init {
        _isgetTableBtnEnable.value = true
        _firstName.value = ""
        _lastName.value = ""
        _email.value = ""
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onGetTable() {
        createCustomer()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createCustomer(){
        val userdata = Customer(firstName = firstName.value, lastName = lastName.value, email = email.value)
        postCustomerService(userdata ,{ createWaitlist(it) }, {})
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createWaitlist(userdata : Customer){
        val waitingData = WaitingData(null, Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()), Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())
        , WaitingStatus.wating, userdata, people.value?.toInt())

        /**fix restaurantId just test for now*/
        addQueueInRestaurant("-MBAe66mDPPlynlus4-e", waitingData, {getTableSuccess(it)}, {})
    }

    fun getTableSuccess(restaurant: WaitingData){
//        _isgetTableBtnEnable.value = false
        _firstName.value = ""
        _lastName.value = ""
        _email.value = ""
        _people.value = ""

        /**Here had set observe so when _getTableData.value change will do add to recycleView*/
        _getTableData.value = restaurant
    }
}