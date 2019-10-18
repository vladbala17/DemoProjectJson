package com.android.vlad.jsonplacerholderdemo.posts.ui

import androidx.lifecycle.ViewModel
import com.android.vlad.jsonplacerholderdemo.posts.data.PostRepository
import javax.inject.Inject

class PostViewModel @Inject constructor(repository: PostRepository) : ViewModel() {

    lateinit var id: String

    val posts by lazy { repository.observePosts(id) }

}