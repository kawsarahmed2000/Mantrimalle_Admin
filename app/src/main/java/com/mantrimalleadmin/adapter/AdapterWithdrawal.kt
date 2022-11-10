package com.mantrimalleadmin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.R
import com.mantrimalleadmin.dataModel.dataWithdrawal

class AdapterWithdrawal(private var newOrdersItemList:ArrayList<dataWithdrawal>):RecyclerView.Adapter<AdapterWithdrawal.MyViewHolder>() {

    private lateinit var mListener : onItemClickListenern
    interface onItemClickListenern {

        fun onItemClickAccept(position: Int)
        fun onItemClick(position: Int)
        fun onItemClickCancel(position: Int)

    }

    fun setOnClicListener(listener: onItemClickListenern){
        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.withdrawl_layout_design,parent,false)


        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(h: MyViewHolder, p: Int) {

        val data : dataWithdrawal = newOrdersItemList[p]
        h.userNameWithdrawal.text=data.userNameWithdrawal
        h.idWithdrawal.text="Id: "+data.idWithdrawal
        h.dateWithdrawal.text=data.dateWithdrawal
        h.status.text=data.status
        h.amountWithdrawal.text="balance: ₹"+data.amountWithdrawal
//        Picasso.get().load(data.profileWithdrawal).into(h.profileWithdrawal)


    }

    override fun getItemCount(): Int {
        return newOrdersItemList.size
    }

    class MyViewHolder(view: View,listener: onItemClickListenern):RecyclerView.ViewHolder(view){

        val amountWithdrawal : TextView = view.findViewById(R.id.amountWithdrawal)
        val profileWithdrawal : ImageView = view.findViewById(R.id.profileWithdrawal)
        val userNameWithdrawal : TextView = view.findViewById(R.id.userNameWithdrawal)
        val idWithdrawal : TextView = view.findViewById(R.id.idWithdrawal)
        val dateWithdrawal : TextView = view.findViewById(R.id.dateWithdrawal)
        val status : TextView = view.findViewById(R.id.status)
        val accept : Button = view.findViewById(R.id.acceptBtnWithdrawal)
        val cancel : Button = view.findViewById(R.id.cancelBtnWithdrawal)

        init {

            accept.setOnClickListener {
                listener.onItemClickAccept(adapterPosition)
            }
            cancel.setOnClickListener {
                listener.onItemClickCancel(adapterPosition)
            }

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}
