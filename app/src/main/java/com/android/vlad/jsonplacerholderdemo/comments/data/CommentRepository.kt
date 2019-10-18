package com.android.vlad.jsonplacerholderdemo.comments.data

import com.android.vlad.jsonplacerholderdemo.data.resultLiveData
import javax.inject.Inject

class CommentRepository @Inject constructor(
    private val dao: CommentDao,
    private val remote: RemoteCommentDataSource
) {
    fun observeComments(userId: String) = resultLiveData(
        databaseQuery = { dao.getComments(userId) },
        networkCall = { remote.fetchData(userId) },
        saveCallResult = { dao.insertAll(it) })
}