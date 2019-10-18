package com.android.vlad.jsonplacerholderdemo.comments.data

import com.android.vlad.jsonplacerholderdemo.api.WebService
import com.android.vlad.jsonplacerholderdemo.data.BaseDataSource
import javax.inject.Inject

class RemoteCommentDataSource @Inject constructor(private val service: WebService) :
    BaseDataSource() {
    suspend fun fetchData(id: String) = getResult { service.getComments(id) }
}