package com.mantrimalleadmin.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.R
import com.mantrimalleadmin.adapter.AdapterWithdrawal
import com.mantrimalleadmin.dataModel.dataWithdrawal
import com.mantrimalleadmin.userDetails

class withdrawl : Fragment() {

    private lateinit var withdrawalRecyclerView: RecyclerView
    private lateinit var withdrawalArrayList: ArrayList<dataWithdrawal>
    private lateinit var withdrawalAdapter: AdapterWithdrawal

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_withdrawl, container, false)

        withdrawalRecyclerView = view.findViewById(R.id.withdrawalRecyclerView)
        withdrawalRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        withdrawalRecyclerView.setHasFixedSize(true)

        withdrawalArrayList = arrayListOf()

        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )
        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )
        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )
        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )
        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )
        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )
        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )
        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )
        withdrawalArrayList.add(
            dataWithdrawal(
                "https://",
                "1000",
                "Kawsar_6876",
                "43675",
                "80-78-2002 10:30pm",
                "Completed"
            )
        )

        withdrawalAdapter = AdapterWithdrawal(withdrawalArrayList)
        withdrawalRecyclerView.adapter = withdrawalAdapter
        withdrawalAdapter.setOnClicListener(object :
            AdapterWithdrawal.onItemClickListenern {
            override fun onItemClickAccept(position: Int) {
                dialogView()
//                Toast.makeText(requireContext(), "Accepted", Toast.LENGTH_LONG).show()
            }

            override fun onItemClick(position: Int) {
                startActivity(Intent(requireContext(), userDetails::class.java))
            }

            override fun onItemClickCancel(position: Int) {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Cancel request")
                builder.setMessage("You want to cancel this request ?")

                builder.setPositiveButton("Yes") { dialog, which ->
                    Toast.makeText(
                        requireContext(),
                        android.R.string.yes, Toast.LENGTH_SHORT
                    ).show()
                }

                builder.setNeutralButton("No") { dialog, which ->
                    Toast.makeText(
                        requireContext(),
                        android.R.string.no, Toast.LENGTH_SHORT
                    ).show()
                }

                builder.show()
            }


        })
        withdrawalAdapter.notifyDataSetChanged()
        return view
    }

    fun dialogView() {

        val dialog = Dialog(requireContext(), R.style.BottomSheetDialogTheme)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setCancelable(true)

        dialog.setContentView(R.layout.bank_details_layout_design)

        dialog.show()
    }
}