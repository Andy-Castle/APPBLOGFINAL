package com.example.appblogfinal.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appblogfinal.R
import com.example.appblogfinal.data.model.Post
import com.example.appblogfinal.databinding.FragmentHomeScreenBinding
import com.example.appblogfinal.ui.home.adapter.HomeScreenAdapter
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private  lateinit var binding: FragmentHomeScreenBinding
    private lateinit var firestore: FirebaseFirestore
    private var postListener: ListenerRegistration? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        firestore = FirebaseFirestore.getInstance()

        val postList = mutableListOf<Post>()
        val adapter = HomeScreenAdapter(postList)
        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHome.adapter = adapter

        // Listener en tiempo real para la colección "posts"
        binding.btnAddPost.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_addPostFragment)
        }

        postListener = firestore.collection("posts")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    return@addSnapshotListener
                }

                if (snapshots != null) {
                    postList.clear()
                    for (doc in snapshots.documents) {
                        val post = doc.toObject(Post::class.java)
                        if (post != null) {
                            postList.add(post)
                        }
                    }
                    adapter.notifyDataSetChanged()
                }
            }
    }
}