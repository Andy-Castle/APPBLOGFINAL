package com.example.appblogfinal.ui.home.adapter

import android.content.Context
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

    // ViewHolder interno que define cómo se visualiza cada post
    inner class HomeScreenViewHolder(val binding: PostItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            // Cargar la imagen del post con Glide
            Glide.with(binding.root.context).load(post.post_image).centerCrop().into(binding.postImage)

            // Cargar la imagen de perfil con Glide
            Glide.with(binding.root.context).load(post.profile_picture).centerCrop().into(binding.profilePicture)

            // Mostrar el nombre del perfil
            binding.profileName.text = post.profile_name

            // Mostrar la hora de la publicación
            //binding.postTimestamp.text = "Hace 2 horas" // Aquí puedes ajustar el timestamp según lo necesites
            post.post_timestamp?.let {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                binding.postTimestamp.text = dateFormat.format(it.toDate())
            } ?: run {
                binding.postTimestamp.text = "Fecha desconocida"
            }
        }
    }

    // Infla el layout para cada item del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenViewHolder {
        val binding = PostItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(binding)
    }

    // Vincula los datos con el ViewHolder
    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) {
        val post = postList[position]
        holder.bind(post)  // Llama a la función bind para asignar los datos del post
    }

    // Retorna la cantidad de elementos en la lista
    override fun getItemCount(): Int = postList.size
}