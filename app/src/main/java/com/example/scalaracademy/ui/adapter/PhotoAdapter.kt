package com.example.scalaracademy.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scalaracademy.data.models.photosDataSource.PhotoResponseItem
import com.example.scalaracademy.databinding.CardPhotoBinding

class PhotoAdapter(context :Context , val data: List<PhotoResponseItem>)  : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {


    val context =context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.PhotoViewHolder {
        val binding: CardPhotoBinding = CardPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoViewHolder, position: Int) {
        (holder as PhotoAdapter.PhotoViewHolder).bind(data.get(position) , context)

    }

    class PhotoViewHolder(bindingCard: CardPhotoBinding) : RecyclerView.ViewHolder(bindingCard.root) {
        val binding = bindingCard

        fun bind(singlePhoto: PhotoResponseItem , context: Context) {
            Glide.with(context).load(singlePhoto.thumbnailUrl).into(binding.photoImage)

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
