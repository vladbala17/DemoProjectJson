package com.android.vlad.jsonplacerholderdemo.api

import com.android.vlad.jsonplacerholderdemo.model.User
import retrofit2.Response
import retrofit2.http.GET

interface WebService {

    companion object {
        const val ENDPOINT = "https://jsonplaceholder.typicode.com"
    }

    @GET("/users")
    suspend fun getUsers(): Response<List<User>>

}