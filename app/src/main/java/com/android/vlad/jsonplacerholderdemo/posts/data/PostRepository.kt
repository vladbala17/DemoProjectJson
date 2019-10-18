package com.android.vlad.jsonplacerholderdemo.posts.data

import com.android.vlad.jsonplacerholderdemo.data.resultLiveData
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val dao: PostDao,
    private val remote: RemotePostDataSource
) {
    fun observePosts(userId: String) = resultLiveData(
        databaseQuery = { dao.getPosts(userId) },
        networkCall = { remote.fetchData(userId) },
        saveCallResult = { dao.insertAll(it) })
}