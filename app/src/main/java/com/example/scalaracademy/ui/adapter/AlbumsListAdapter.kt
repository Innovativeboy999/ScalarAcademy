package com.example.scalaracademy.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scalaracademy.data.models.albummodels.AlbumResponseItem
import com.example.scalaracademy.databinding.AlbumCardViewBinding

class AlbumsListAdapter(private val contextActivity: Context, val data: List<AlbumResponseItem>)  : RecyclerView.Adapter<AlbumsListAdapter.AlbumViewHolder>()
{

    var isExpanded = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsListAdapter.AlbumViewHolder {
       val binding : AlbumCardViewBinding = AlbumCardViewBinding.inflate(LayoutInflater.from(parent.context) , parent , false )
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumsListAdapter.AlbumViewHolder, position: Int)
    {
        (holder as AlbumsListAdapter.AlbumViewHolder).bind(data.get(position) , contextActivity)

        holder.itemView.setOnClickListener {
            isExpanded = !isExpanded
            holder.expanded(isExpanded)
            notifyItemChanged(position)
        }
    }

    class AlbumViewHolder(bindingCard : AlbumCardViewBinding) :RecyclerView.ViewHolder(bindingCard.root)
    {
        val binding = bindingCard

        fun bind( singleAlbum : AlbumResponseItem, contextActivity : Context )
        {
            binding.albumName.text = singleAlbum.title

        }

        fun expanded( isExpanded : Boolean)
        {
            if(isExpanded)
            {
                binding.recyclerViewInsideCard.visibility = View.VISIBLE
                binding.experimentTest.visibility = View.VISIBLE
            }
            else{
                binding.recyclerViewInsideCard.visibility = View.GONE
                binding.experimentTest.visibility = View.GONE
            }

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}