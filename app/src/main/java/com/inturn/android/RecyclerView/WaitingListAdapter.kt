package com.inturn.android.RecyclerView

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.inturn.android.model.WaitingData
import com.inturn.android.R
import com.inturn.android.databinding.LayoutRecyclerViewItemBinding

class WaitingListAdapter(private val waitingList: ArrayList<WaitingData>): RecyclerView.Adapter<WaitingListAdapter.WaitingDataViewHolder>() {

    override fun getItemCount() = waitingList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaitingDataViewHolder {
        return WaitingDataViewHolder(
            DataBindingUtil.inflate<LayoutRecyclerViewItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.layout_recycler_view_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WaitingDataViewHolder, position: Int) {
        holder.recyclerviewWaitingData.waitingdata = waitingList[position]
    }

    inner class WaitingDataViewHolder(val recyclerviewWaitingData: LayoutRecyclerViewItemBinding): RecyclerView.ViewHolder(recyclerviewWaitingData.root)


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WLViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_view_item, parent, false)
//        return WLViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int = waitingList.size
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    override fun onBindViewHolder(holder: WLViewHolder, position: Int) {
//
//
//
//
//        holder.bind(waitingList[position])
//    }
//
//    inner class WLViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        private val firstNameTextView: TextView = itemView.findViewById(R.id.firstNameTextView)
//        private val lastNameTextView: TextView = itemView.findViewById(R.id.lastNameTextView)
//
//        private val checkTimeTextView: TextView = itemView.findViewById(R.id.checkTimeTextView)
//        private val expectedTimeTextView: TextView = itemView.findViewById(R.id.expectedTimeTextView)
////        private val statusTextView: TextView = itemView.findViewById(R.id.statusTextView)
////        private val customerTextView: TextView = itemView.findViewById(R.id.customerTextView)
//        private val peopleTextView: TextView = itemView.findViewById(R.id.peopleTextView)
//
//        @RequiresApi(Build.VERSION_CODES.O)
//        fun bind(item: WaitingData) {
//            firstNameTextView.text = item.customer?.firstName
//            lastNameTextView.text = item.customer?.lastName
//            checkTimeTextView.text = "${item.checkTime?.hours}:${item.checkTime?.minutes}"
//            expectedTimeTextView.text =  "${item.expectedTime?.hours}:${item.expectedTime?.minutes}"
////            statusTextView.text = item.status.toString()
//            peopleTextView.text = item.people.toString()
//        }
//    }
}
