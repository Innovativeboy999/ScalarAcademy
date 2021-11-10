package com.example.scalaracademy.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scalaracademy.R
import com.example.scalaracademy.data.api.ScalarClient
import com.example.scalaracademy.data.api.ScalarInterface
import com.example.scalaracademy.ui.adapter.AlbumsListAdapter
import com.example.scalaracademy.ui.adapter.UserListAdapter
import com.example.scalaracademy.ui.viewmodels.AlbumListViewModel
import com.example.scalaracademy.ui.viewmodels.UserListViewModel
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity()
{
    private val albumListViewModel : AlbumListViewModel by viewModels()
    val apiService : ScalarInterface = ScalarClient.getClient()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter : AlbumsListAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        linearLayoutManager = LinearLayoutManager(this)
        albumRecyclerView.layoutManager =linearLayoutManager
        albumRecyclerView.setHasFixedSize(true)
        if(intent.hasExtra("id"))
        {
            albumListViewModel.fetchUsersList(apiService , intent.getIntExtra("id" , 1))
                    .observe(this , Observer {
                        adapter = AlbumsListAdapter(this , it )
                        albumRecyclerView.adapter =adapter
                    })



        }

    }
}