package com.android.vlad.jsonplacerholderdemo.comments.ui

import androidx.lifecycle.ViewModel
import com.android.vlad.jsonplacerholderdemo.comments.data.CommentRepository
import javax.inject.Inject

class CommentViewModel @Inject constructor(repository: CommentRepository) : ViewModel() {

    lateinit var id: String

    val comments by lazy { repository.observeComments(id) }

}