package com.example.appblogfinal.ui.addpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appblogfinal.R
import com.example.appblogfinal.data.model.Post
import com.example.appblogfinal.databinding.FragmentAddPostBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddPostFragment : Fragment(R.layout.fragment_add_post) {
    private lateinit var binding: FragmentAddPostBinding
    private lateinit var firestore: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firestore = FirebaseFirestore.getInstance()

        binding.btnSubmitPost.setOnClickListener {
            val profileName = binding.etProfileName.text.toString()
            val profilePicture = binding.etProfilePicture.text.toString()
            val postImage = binding.etPostImage.text.toString()
            val description = binding.etDescription.text.toString()

            val post = Post(
                profile_name = profileName,
                profile_picture = profilePicture,
                post_image = postImage,
                description = description,
                post_timestamp = com.google.firebase.Timestamp.now()
            )

            firestore.collection("posts").add(post)
                .addOnSuccessListener {
                    findNavController().navigate(R.id.action_addPostFragment_to_homeScreenFragment)
                }
                .addOnFailureListener {
                    // Handle failure
                }
        }
    }
}