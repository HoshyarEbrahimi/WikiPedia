package com.hoshyar.ebrahimi.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hoshyar.ebrahimi.wikipedia.databinding.FragmentPhotographerBinding

class FragmentPhotographer : Fragment() {
	 lateinit var binding: FragmentPhotographerBinding
	 override fun onCreateView(
			inflater: LayoutInflater ,
			container: ViewGroup? ,
			savedInstanceState: Bundle?
	 ): View {
			binding = FragmentPhotographerBinding.inflate(layoutInflater , container , false)
			return binding.root
			
	 }
	 
	 override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
			super.onViewCreated(view , savedInstanceState)
			
			
	 }
	 
	 
}