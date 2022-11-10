package com.mantrimalleadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mantrimalleadmin.adapter.AdapterUser
import com.mantrimalleadmin.dataModel.dataUser
import com.mantrimalleadmin.databinding.ActivityUsersBinding

class users : AppCompatActivity() {

    private lateinit var newOrdersRecyclerView: RecyclerView
    private lateinit var newOrdersArrayList: ArrayList<dataUser>
    private lateinit var newOrdersAdapter: AdapterUser

    private lateinit var binding: ActivityUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newOrdersRecyclerView = findViewById(R.id.userRecyclerView)
        newOrdersRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        newOrdersRecyclerView.setHasFixedSize(true)

        newOrdersArrayList = arrayListOf()
        binding.backBtnUsers.setOnClickListener {
            finish()
        }

        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))
        newOrdersArrayList.add(dataUser("kawsar", "8977", "896786", "9786785686", "https"))

        newOrdersAdapter = AdapterUser(newOrdersArrayList)
        newOrdersRecyclerView.adapter = newOrdersAdapter
        newOrdersAdapter.setOnClicListener(object :
            AdapterUser.onItemClickListenern {
            override fun onItemClickAccept(position: Int) {
                Toast.makeText(this@users, "Accepted", Toast.LENGTH_LONG).show()
            }

            override fun onItemClickReject(position: Int) {

                Toast.makeText(this@users, "Rejected", Toast.LENGTH_LONG).show()
            }

        })
        newOrdersAdapter.notifyDataSetChanged()

    }
}