package com.android.vlad.jsonplacerholderdemo.di


import com.android.vlad.jsonplacerholderdemo.posts.ui.PostFragment
import com.android.vlad.jsonplacerholderdemo.users.ui.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeUserFragment(): UserFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment
}
