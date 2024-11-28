package com.example.appblogfinal.domain

import com.example.appblogfinal.core.Resource
import com.example.appblogfinal.data.model.Post

interface HomeScreenRepo {
    suspend fun getLatestPost(): Resource<List<Post>>
}