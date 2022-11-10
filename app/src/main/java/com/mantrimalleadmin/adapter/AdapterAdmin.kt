package com.mantrimalleadmin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.R
import com.mantrimalleadmin.dataModel.dataAdmin
import com.mantrimalleadmin.dataModel.dataUser

class AdapterAdmin(private var newOrdersItemList:ArrayList<dataAdmin>):RecyclerView.Adapter<AdapterAdmin.MyViewHolder>() {

    private lateinit var mListener : onItemClickListenern
    interface onItemClickListenern {

        fun onItemClickEditAdmin(position: Int)
        fun onItemClickBlockAdmin(position: Int)
        fun onItemClickDeleteAdmin(position: Int)
        fun onItemClick(position: Int)

    }

    fun setOnClicListener(listener: onItemClickListenern){
        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.admin_list_item_layout_design,parent,false)


        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(h: MyViewHolder, p: Int) {

        val data : dataAdmin = newOrdersItemList[p]
        h.nameAdmin.text=data.nameAdmin
        h.usernameAdmin.text=data.usernameAdmin
        h.adminId.text=data.adminId
        h.joiningDate.text=data.joiningDate


//        Picasso.get().load(data.profileAdmin).into(h.profileAdmin)


    }

    override fun getItemCount(): Int {
        return newOrdersItemList.size
    }

    class MyViewHolder(view: View,listener: onItemClickListenern):RecyclerView.ViewHolder(view){

        val nameAdmin : TextView = view.findViewById(R.id.nameAdmin)
        val profileAdmin : ImageView = view.findViewById(R.id.profileAdmin)
        val usernameAdmin : TextView = view.findViewById(R.id.usernameAdmin)
        val adminId : TextView = view.findViewById(R.id.adminId)
        val joiningDate : TextView = view.findViewById(R.id.joiningDate)

        val editAdmin : ImageView = view.findViewById(R.id.editAdmin)
        val blockAdmin : ImageView = view.findViewById(R.id.blockAdmin)
        val deleteAdmin : ImageView = view.findViewById(R.id.deleteAdmin)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
            editAdmin.setOnClickListener {
                listener.onItemClickEditAdmin(adapterPosition)
            }
            blockAdmin.setOnClickListener {
                listener.onItemClickBlockAdmin(adapterPosition)
            }
            deleteAdmin.setOnClickListener {
                listener.onItemClickDeleteAdmin(adapterPosition)
            }

        }
    }
}
