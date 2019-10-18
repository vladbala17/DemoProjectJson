package com.android.vlad.jsonplacerholderdemo.posts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.vlad.jsonplacerholderdemo.databinding.ListItemPostBinding
import com.android.vlad.jsonplacerholderdemo.model.Post

class PostAdapter : ListAdapter<Post, PostAdapter.PostViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ListItemPostBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.apply {
            bind(createOnClickListener(post.id), post)
        }
    }

    private fun createOnClickListener(id: String): View.OnClickListener {
        return View.OnClickListener {
        }
    }

    class PostViewHolder(private val binding: ListItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, postItem: Post) {
            binding.apply {
                clickListener = listener
                post = postItem
                executePendingBindings()
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Post>() {

        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}