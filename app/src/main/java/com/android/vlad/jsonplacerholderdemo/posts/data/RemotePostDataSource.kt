package com.android.vlad.jsonplacerholderdemo.posts.data

import com.android.vlad.jsonplacerholderdemo.api.WebService
import com.android.vlad.jsonplacerholderdemo.data.BaseDataSource
import javax.inject.Inject

class RemotePostDataSource @Inject constructor(private val service: WebService) : BaseDataSource() {
    suspend fun fetchData(id: String) = getResult { service.getPosts(id) }
}