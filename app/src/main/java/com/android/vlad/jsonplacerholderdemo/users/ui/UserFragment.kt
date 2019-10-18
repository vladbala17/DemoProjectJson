package com.android.vlad.jsonplacerholderdemo.users.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.vlad.jsonplacerholderdemo.databinding.FragmentUsersBinding

class UserFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentUsersBinding.inflate(inflater, container, false)
        context ?: return binding.root


        return binding.root
    }


}