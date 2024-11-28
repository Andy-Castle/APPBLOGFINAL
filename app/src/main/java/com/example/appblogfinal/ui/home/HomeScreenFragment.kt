package com.example.appblogfinal.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appblogfinal.R
import com.example.appblogfinal.core.Resource
import com.example.appblogfinal.data.model.Post
import com.example.appblogfinal.data.remote.HomeScreenDataSource
import com.example.appblogfinal.databinding.FragmentHomeScreenBinding
import com.example.appblogfinal.domain.HomeScreenRepoImpl
import com.example.appblogfinal.presentation.HomeScreenViewModel
import com.example.appblogfinal.presentation.HomeScreenViewModelFactory
import com.example.appblogfinal.ui.home.adapter.HomeScreenAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeScreenViewModel> {
        HomeScreenViewModelFactory(HomeScreenRepoImpl(HomeScreenDataSource()))
    }
    private lateinit var firestore: FirebaseFirestore
    private var postListener: ListenerRegistration? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)
        firestore = FirebaseFirestore.getInstance()

        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())

        viewModel.fetchLatestPosts().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvHome.adapter = HomeScreenAdapter(result.data)
                }
                is Resource.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        "Ocurrió un error: ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

        binding.btnAddPost.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_addPostFragment)
        }
    }
}