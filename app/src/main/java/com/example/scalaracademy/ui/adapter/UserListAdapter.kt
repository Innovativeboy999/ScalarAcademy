package com.example.scalaracademy.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scalaracademy.R
import com.example.scalaracademy.data.models.usermodels.UserResponseItem
import com.example.scalaracademy.databinding.CardListUsersBinding
import com.example.scalaracademy.ui.activities.AlbumActivity

class UserListAdapter(private val contextActivity: Context , val data: List<UserResponseItem>)  : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {


    class UserViewHolder(bindingCard: CardListUsersBinding) :RecyclerView.ViewHolder(bindingCard.root)
    {
        var binding =bindingCard
        fun bind(singleUser : UserResponseItem , contextActivity: Context)
        {

            binding.root.setOnClickListener {
                val intent = Intent(contextActivity, AlbumActivity::class.java)
                intent.putExtra("id", singleUser.id)
                contextActivity.startActivity(intent)
            }

            binding.name.text = singleUser.name
            binding.email.text = singleUser.email
            binding.address.text = singleUser.address.street + " " + singleUser.address.city
            binding.phone.text = singleUser.phone
            binding.userId.text = singleUser.id.toString()
        }
    }


    override fun getItemCount(): Int {
       return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding : CardListUsersBinding = CardListUsersBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        (holder as UserViewHolder).bind(data.get(position) , contextActivity)
    }
}