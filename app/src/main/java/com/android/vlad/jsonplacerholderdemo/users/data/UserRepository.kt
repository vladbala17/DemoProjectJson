package com.android.vlad.jsonplacerholderdemo.users.data

import com.android.vlad.jsonplacerholderdemo.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val dao: UserDao,
    private val remote: RemoteUserDataSource
) {

    val users = resultLiveData(databaseQuery = { dao.getUsers() },
        networkCall = { remote.fetchData() },
        saveCallResult = { dao.insertAll(it) })

}