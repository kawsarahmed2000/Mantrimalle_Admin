package com.mantrimalleadmin

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.adapter.AdapterAdmin
import com.mantrimalleadmin.dataModel.dataAdmin
import com.mantrimalleadmin.dataModel.dataUser
import com.mantrimalleadmin.databinding.ActivityAdminBinding

class admin : AppCompatActivity() {

    private lateinit var adminRecyclerView: RecyclerView
    private lateinit var adminArrayList: ArrayList<dataAdmin>
    private lateinit var adminAdapter: AdapterAdmin

    private lateinit var binding: ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adminRecyclerView = findViewById(R.id.adminRecyclerView)
        adminRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adminRecyclerView.setHasFixedSize(true)

        adminArrayList = arrayListOf()
        binding.backBtnUsers.setOnClickListener {
            finish()
        }

        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))
        adminArrayList.add(dataAdmin("kawsar", "https://", "Admin_325", "345", "9834634564","2022-10-08 10:12:13"))

        adminAdapter = AdapterAdmin(adminArrayList)
        adminRecyclerView.adapter = adminAdapter
        adminAdapter.setOnClicListener(object :
            AdapterAdmin.onItemClickListenern {
            override fun onItemClickEditAdmin(position: Int) {
                dialogView(adminArrayList[position].usernameAdmin.toString(),adminArrayList[position].mobileNumber.toString())
            }

            override fun onItemClickBlockAdmin(position: Int) {
                val builder = AlertDialog.Builder(this@admin)
                builder.setTitle("Block Admin")
                builder.setMessage("You want to block Admin ?")

                builder.setPositiveButton("Confirm") { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        "Confirm", Toast.LENGTH_SHORT
                    ).show()
                }

                builder.setNeutralButton("Cancel") { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        "Cancel", Toast.LENGTH_SHORT
                    ).show()
                }

                builder.show()
            }

            override fun onItemClickDeleteAdmin(position: Int) {
                val builder = AlertDialog.Builder(this@admin)
                builder.setTitle("Delete Admin")
                builder.setMessage("You want to Delete Admin ?")

                builder.setPositiveButton("Confirm") { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        "Confirm", Toast.LENGTH_SHORT
                    ).show()
                }

                builder.setNeutralButton("Cancel") { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        "Cancel", Toast.LENGTH_SHORT
                    ).show()
                }

                builder.show()
            }

            override fun onItemClick(position: Int) {
                startActivity(Intent(this@admin,userDetails::class.java))
            }

        })
        adminAdapter.notifyDataSetChanged()

    }


    fun dialogView(userId:String,mobileNo:String) {

        val dialog = Dialog(this@admin, R.style.BottomSheetDialogTheme)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setCancelable(true)

        dialog.setContentView(R.layout.admin_edit_details_layout_design)
        
        val closeBtn = dialog.findViewById<ImageView>(R.id.closeBtn)
        val editDetailsHeaderTV = dialog.findViewById<TextView>(R.id.editDetailsHeaderTV)
        val submitBtn = dialog.findViewById<TextView>(R.id.submitBtn)
        val userIdET = dialog.findViewById<EditText>(R.id.userIdET)
        val mobileNumberET = dialog.findViewById<EditText>(R.id.mobileNumberET)
        
        userIdET.setText(userId.toString())
        mobileNumberET.setText(mobileNo.toString())
        closeBtn.setOnClickListener { 
            dialog.hide()
        }
        

        dialog.show()
    }
}