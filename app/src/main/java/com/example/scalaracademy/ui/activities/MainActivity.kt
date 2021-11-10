package com.example.scalaracademy.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scalaracademy.R
import com.example.scalaracademy.data.api.ScalarClient
import com.example.scalaracademy.data.api.ScalarInterface
import com.example.scalaracademy.ui.adapter.UserListAdapter
import com.example.scalaracademy.ui.viewmodels.UserListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    private val userListViewModel :UserListViewModel by viewModels()
    val apiService : ScalarInterface = ScalarClient.getClient()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter : UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        userRecyclerView.layoutManager = linearLayoutManager

        userListViewModel.fetchUsersList(apiService).observe(this , Observer {
            Log.i("11111", "onCreate: " + it.get(0).address)
            adapter = UserListAdapter(this , it)
            userRecyclerView.adapter = adapter
        })
    }

}