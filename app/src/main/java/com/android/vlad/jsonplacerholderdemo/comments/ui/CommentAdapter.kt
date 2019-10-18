package com.android.vlad.jsonplacerholderdemo.comments.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.vlad.jsonplacerholderdemo.databinding.ListItemCommentBinding
import com.android.vlad.jsonplacerholderdemo.databinding.ListItemPostBinding
import com.android.vlad.jsonplacerholderdemo.model.Comment
import com.android.vlad.jsonplacerholderdemo.model.Post
import com.android.vlad.jsonplacerholderdemo.posts.ui.PostAdapter

class CommentAdapter : ListAdapter<Comment, CommentAdapter.CommentViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            ListItemCommentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = getItem(position)
        holder.apply {
            bind(createOnClickListener(comment.id), comment)
        }
    }

    private fun createOnClickListener(id: String): View.OnClickListener {
        return View.OnClickListener {
        }
    }

    class CommentViewHolder(private val binding: ListItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, commentItem: Comment) {
            binding.apply {
                clickListener = listener
                comment = commentItem
                executePendingBindings()
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Comment>() {

        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }
    }
}