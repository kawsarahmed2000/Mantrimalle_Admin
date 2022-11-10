package com.mantrimalleadmin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.R
import com.mantrimalleadmin.adapter.AdapterAdmin
import com.mantrimalleadmin.adapter.AdapterTransaction
import com.mantrimalleadmin.adapter.AdapterUser
import com.mantrimalleadmin.dataModel.dataAdmin
import com.mantrimalleadmin.dataModel.dataTransaction

class transactions : Fragment() {

    private lateinit var transactionRecyclerView: RecyclerView
    private lateinit var transactionArrayList: ArrayList<dataTransaction>
    private lateinit var transactionnAdapter: AdapterTransaction
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transactions, container, false)

        transactionRecyclerView = view.findViewById(R.id.transactionRecyclerView)
        transactionRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        transactionRecyclerView.setHasFixedSize(true)

        transactionArrayList = arrayListOf()
        
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        transactionArrayList.add(dataTransaction("Kawsar ahmed","TNX8767869","3556"))
        
        
        transactionnAdapter= AdapterTransaction(transactionArrayList)
        transactionRecyclerView.adapter=transactionnAdapter
        transactionnAdapter.setOnClicListener(object : AdapterTransaction.onItemClickListenern{
            override fun onItemClick(position: Int) {
                Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
            }

        })


        return view
    }

}