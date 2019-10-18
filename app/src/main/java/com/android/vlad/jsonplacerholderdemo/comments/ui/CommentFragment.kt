package com.android.vlad.jsonplacerholderdemo.comments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.android.vlad.jsonplacerholderdemo.data.Result
import com.android.vlad.jsonplacerholderdemo.databinding.FragmentCommentsBinding
import com.android.vlad.jsonplacerholderdemo.databinding.FragmentPostsBinding
import com.android.vlad.jsonplacerholderdemo.databinding.FragmentUsersBinding
import com.android.vlad.jsonplacerholderdemo.di.Injectable
import com.android.vlad.jsonplacerholderdemo.di.injectViewModel
import com.android.vlad.jsonplacerholderdemo.posts.ui.PostAdapter
import com.android.vlad.jsonplacerholderdemo.posts.ui.PostFragmentArgs
import com.android.vlad.jsonplacerholderdemo.posts.ui.PostViewModel
import com.android.vlad.jsonplacerholderdemo.util.hide
import com.android.vlad.jsonplacerholderdemo.util.setTitle
import com.android.vlad.jsonplacerholderdemo.util.show
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class CommentFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CommentViewModel

    private val args: CommentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        viewModel.id = args.postId

        val binding = FragmentCommentsBinding.inflate(inflater, container, false)
        context ?: return binding.root
        setTitle("Comments")
        val adapter = CommentAdapter()
        binding.commentsRecyclerView.adapter = adapter
        subscribeUi(binding, adapter)

        return binding.root
    }

    private fun subscribeUi(binding: FragmentCommentsBinding, adapter: CommentAdapter) {
        viewModel.comments.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    result.data.let { adapter.submitList(it) }
                }
                Result.Status.LOADING -> binding.progressBar.show()
                Result.Status.ERROR -> {
                    binding.progressBar.hide()
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }
}