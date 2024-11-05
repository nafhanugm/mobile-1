package com.nafhan.myapplication

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityPert11Binding
import com.nafhan.myapplication.model.Data
import com.nafhan.myapplication.model.Users
import com.nafhan.myapplication.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger

class Pert11Activity: AppCompatActivity() {
    private lateinit var binding: ActivityPert11Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert11Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        val userList = ArrayList<Data>()
        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                for (i in response.body()!!.data) {
                    userList.add(i)
                }
                val listAdapter = CustomListView(this@Pert11Activity, R.layout.simple_list_item_1)
                listAdapter.setItems(userList)
                binding.lvNama.adapter = listAdapter
            }
            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@Pert11Activity, t.message.toString(),
                    Toast.LENGTH_LONG).show()
                Log.d("Error", t.message.toString())
            }
        })
    }

}