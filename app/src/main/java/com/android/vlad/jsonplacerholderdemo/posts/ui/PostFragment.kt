package com.android.vlad.jsonplacerholderdemo.posts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.android.vlad.jsonplacerholderdemo.data.Result
import com.android.vlad.jsonplacerholderdemo.databinding.FragmentUsersBinding
import com.android.vlad.jsonplacerholderdemo.di.Injectable
import com.android.vlad.jsonplacerholderdemo.di.injectViewModel
import com.android.vlad.jsonplacerholderdemo.util.hide
import com.android.vlad.jsonplacerholderdemo.util.show
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class PostFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: PostViewModel

    private val args: PostFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        viewModel.id = args.userId

        val binding = FragmentUsersBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = PostAdapter()
        binding.usersRecyclerView.adapter = adapter
        subscribeUi(binding, adapter)

        return binding.root
    }

    private fun subscribeUi(binding: FragmentUsersBinding, adapter: PostAdapter) {
        viewModel.posts.observe(viewLifecycleOwner, Observer { result ->
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