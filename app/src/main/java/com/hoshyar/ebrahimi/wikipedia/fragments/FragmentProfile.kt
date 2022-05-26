package com.hoshyar.ebrahimi.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hoshyar.ebrahimi.wikipedia.databinding.FragmentExploreBinding
import com.hoshyar.ebrahimi.wikipedia.databinding.FragmentProfileBinding

class FragmentProfile :Fragment() {
	 lateinit var binding: FragmentProfileBinding
	 override fun onCreateView(
			inflater: LayoutInflater ,
			container: ViewGroup? ,
			savedInstanceState: Bundle?
	 ): View? {
			binding = FragmentProfileBinding.inflate(layoutInflater , container , false)
			return binding.root	 }
}