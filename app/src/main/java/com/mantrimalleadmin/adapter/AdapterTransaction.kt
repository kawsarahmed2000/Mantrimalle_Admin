package com.mantrimalleadmin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.R
import com.mantrimalleadmin.dataModel.dataAdmin
import com.mantrimalleadmin.dataModel.dataTransaction
import com.mantrimalleadmin.dataModel.dataUser

class AdapterTransaction(private var newOrdersItemList:ArrayList<dataTransaction>):RecyclerView.Adapter<AdapterTransaction.MyViewHolder>() {

    private lateinit var mListener : onItemClickListenern
    interface onItemClickListenern {

        fun onItemClick(position: Int)

    }

    fun setOnClicListener(listener: onItemClickListenern){
        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.transaction_layout_design,parent,false)


        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(h: MyViewHolder, p: Int) {

        val data : dataTransaction = newOrdersItemList[p]
        h.nameTransaction.text=data.name
        h.amountTransaction.text="₹ "+data.amount
        h.tnx_idTransaction.text=data.tnx_id


    }

    override fun getItemCount(): Int {
        return newOrdersItemList.size
    }

    class MyViewHolder(view: View,listener: onItemClickListenern):RecyclerView.ViewHolder(view){

        val nameTransaction : TextView = view.findViewById(R.id.nameTransaction)
        val amountTransaction : TextView = view.findViewById(R.id.amountTransaction)
        val tnx_idTransaction : TextView = view.findViewById(R.id.tnx_idTransaction)


        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}
