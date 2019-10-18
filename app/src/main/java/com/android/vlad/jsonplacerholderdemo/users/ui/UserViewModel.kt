package com.android.vlad.jsonplacerholderdemo.users.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.vlad.jsonplacerholderdemo.data.Result
import com.android.vlad.jsonplacerholderdemo.model.User
import com.android.vlad.jsonplacerholderdemo.users.data.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(userRepository: UserRepository) : ViewModel() {
    val users: LiveData<Result<List<User>>> = userRepository.users
}