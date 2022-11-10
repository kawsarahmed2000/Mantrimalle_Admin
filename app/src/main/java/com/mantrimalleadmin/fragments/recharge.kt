package com.mantrimalleadmin.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.R
import com.mantrimalleadmin.adapter.AdapterRecharge
import com.mantrimalleadmin.dataModel.dataRecharge
import com.mantrimalleadmin.userDetails

class recharge : Fragment() {

    private lateinit var rechargeRecyclerView: RecyclerView
    private lateinit var rechargeArrayList: ArrayList<dataRecharge>
    private lateinit var rechargeAdapter: AdapterRecharge

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recharge, container, false)

        rechargeRecyclerView = view.findViewById(R.id.rechargeRecyclerView)
        rechargeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rechargeRecyclerView.setHasFixedSize(true)

        rechargeArrayList = arrayListOf()

        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))
        rechargeArrayList.add(dataRecharge("https://", "1000", "Kawsar_6876", "43675", "80-78-2002 10:30pm",))

        rechargeAdapter = AdapterRecharge(rechargeArrayList)
        rechargeRecyclerView.adapter = rechargeAdapter
        rechargeAdapter.setOnClicListener(object :
            AdapterRecharge.onItemClickListenern {
            override fun onItemClickAccept(position: Int) {

                startActivity(Intent(requireContext(), userDetails::class.java))
            }

            override fun onItemClickReject(position: Int) {

                Toast.makeText(requireContext(), "Rejected", Toast.LENGTH_LONG).show()
            }

        })
        rechargeAdapter.notifyDataSetChanged()

        return view

    }

}