package com.android.vlad.jsonplacerholderdemo.users.data

import com.android.vlad.jsonplacerholderdemo.api.WebService
import com.android.vlad.jsonplacerholderdemo.data.BaseDataSource
import javax.inject.Inject

class RemoteUserDataSource @Inject constructor(private val service: WebService) : BaseDataSource() {

    suspend fun fetchData() = getResult { service.getUsers() }
}