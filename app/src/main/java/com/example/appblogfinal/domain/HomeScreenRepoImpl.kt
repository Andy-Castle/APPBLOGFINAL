package com.example.appblogfinal.domain

import com.example.appblogfinal.core.Resource
import com.example.appblogfinal.data.model.Post
import com.example.appblogfinal.data.remote.HomeScreenDataSource

class HomeScreenRepoImpl(private val dataSource: HomeScreenDataSource): HomeScreenRepo {
    override suspend fun getLatestPost(): Resource<List<Post>> = dataSource.getLatestPosts()
}