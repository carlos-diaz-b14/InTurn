package com.inturn.android.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inturn.android.Model.WaitingData
import com.inturn.android.R
import kotlin.collections.ArrayList

class WaitingListAdapter(private val waitingList: ArrayList<WaitingData>): RecyclerView.Adapter<WaitingListAdapter.WLViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WLViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_view_item, parent, false)
        return WLViewHolder(itemView)
    }

    override fun getItemCount(): Int = waitingList.size

    override fun onBindViewHolder(holder: WLViewHolder, position: Int) {
        holder.bind(waitingList[position])
    }

    // ViewHolder
    inner class WLViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val checkTimeTextView: TextView = itemView.findViewById(R.id.checkTimeTextView)
        private val expectedTimeTextView: TextView = itemView.findViewById(R.id.expectedTimeTextView)
        private val statusTextView: TextView = itemView.findViewById(R.id.statusTextView)
        private val customerTextView: TextView = itemView.findViewById(R.id.customerTextView)
        private val peopleTextView: TextView = itemView.findViewById(R.id.peopleTextView)

        fun bind(item: WaitingData) {
            checkTimeTextView.text = item.checkTime.toString()
            expectedTimeTextView.text = item.expectedTime.toString()
            statusTextView.text = item.status.toString()
            customerTextView.text = item.customer.toString()
            peopleTextView.text = item.people.toString()
        }

    }

}
