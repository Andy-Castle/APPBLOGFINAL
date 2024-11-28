package com.example.appblogfinal.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appblogfinal.core.BaseViewHolder
import com.example.appblogfinal.data.model.Post
import com.example.appblogfinal.databinding.PostItemViewBinding
import java.text.SimpleDateFormat
import java.util.Locale

class HomeScreenAdapter(private val postList: List<Post>) : RecyclerView.Adapter<HomeScreenAdapter.HomeScreenViewHolder>() {

    inner class HomeScreenViewHolder(val binding: PostItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            Glide.with(binding.root.context).load(post.post_image).centerCrop().into(binding.postImage)
            Glide.with(binding.root.context).load(post.profile_picture).centerCrop().into(binding.profilePicture)
            binding.profileName.text = post.profile_name
            post.post_timestamp?.let {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                binding.postTimestamp.text = dateFormat.format(it.toDate())
            } ?: run {
                binding.postTimestamp.text = "Fecha desconocida"
            }
            binding.postDescription.text = post.description // Asignar la descripción
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenViewHolder {
        val binding = PostItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) {
        val post = postList[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = postList.size
}