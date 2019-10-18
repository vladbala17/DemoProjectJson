package com.android.vlad.jsonplacerholderdemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.vlad.jsonplacerholderdemo.comments.ui.CommentViewModel
import com.android.vlad.jsonplacerholderdemo.posts.ui.PostViewModel
import com.android.vlad.jsonplacerholderdemo.users.ui.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(viewModel: UserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(viewModel: PostViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CommentViewModel::class)
    abstract fun bindCommentViewModel(viewModel: CommentViewModel): ViewModel

}
