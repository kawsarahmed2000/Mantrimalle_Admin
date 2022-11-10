package com.mantrimalleadmin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.R
import com.mantrimalleadmin.dataModel.dataUser

class AdapterUser(private var newOrdersItemList:ArrayList<dataUser>):RecyclerView.Adapter<AdapterUser.MyViewHolder>() {

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

        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout_design,parent,false)


        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(h: MyViewHolder, p: Int) {

        val data : dataUser = newOrdersItemList[p]
        h.name.text=data.userName
        h.userId.text="userId: "+data.userId
        h.mobileNumber.text="+91"+data.mobileNumber
        h.balance.text="balance: ₹"+data.balance
//        Picasso.get().load(data.profileImage).into(h.profile)


    }

    override fun getItemCount(): Int {
        return newOrdersItemList.size
    }

    class MyViewHolder(view: View,listener: onItemClickListenern):RecyclerView.ViewHolder(view){

        val name : TextView = view.findViewById(R.id.usernameUser)
        val profile : ImageView = view.findViewById(R.id.profileUser)
        val userId : TextView = view.findViewById(R.id.userIdUser)
        val mobileNumber : TextView = view.findViewById(R.id.mobileNumberUser)
        val balance : TextView = view.findViewById(R.id.balanceUser)

        init {

        }
    }
}
