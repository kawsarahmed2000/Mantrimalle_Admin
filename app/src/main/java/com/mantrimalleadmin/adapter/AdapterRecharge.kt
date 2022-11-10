package com.mantrimalleadmin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.R
import com.mantrimalleadmin.dataModel.dataRecharge

class AdapterRecharge(private var newOrdersItemList:ArrayList<dataRecharge>):RecyclerView.Adapter<AdapterRecharge.MyViewHolder>() {

    private lateinit var mListener : onItemClickListenern
    interface onItemClickListenern {

        fun onItemClickAccept(position: Int)
        fun onItemClickReject(position: Int)

    }

    fun setOnClicListener(listener: onItemClickListenern){
        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recharge_layout_design,parent,false)


        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(h: MyViewHolder, p: Int) {

        val data : dataRecharge = newOrdersItemList[p]
        h.usernameRecharge.text=data.usernameRecharge
        h.idRecharge.text="Id: "+data.idRecharge
        h.dateRecharge.text=data.dateRecharge
        h.amountRecharge.text="balance: ₹"+data.amountRecharge
//        Picasso.get().load(data.profileRecharge).into(h.profileRecharge)


    }

    override fun getItemCount(): Int {
        return newOrdersItemList.size
    }

    class MyViewHolder(view: View,listener: onItemClickListenern):RecyclerView.ViewHolder(view){

        val amountRecharge : TextView = view.findViewById(R.id.amountRecharge)
        val profileRecharge : ImageView = view.findViewById(R.id.profileRecharge)
        val usernameRecharge : TextView = view.findViewById(R.id.usernameRecharge)
        val idRecharge : TextView = view.findViewById(R.id.idRecharge)
        val dateRecharge : TextView = view.findViewById(R.id.dateRecharge)

        init {

            itemView.setOnClickListener {
                listener.onItemClickAccept(adapterPosition)
            }
        }
    }
}
