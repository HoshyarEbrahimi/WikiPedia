package com.hoshyar.ebrahimi.wikipedia.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hoshyar.ebrahimi.wikipedia.data.ItemPost
import com.hoshyar.ebrahimi.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter(private val data: ArrayList<ItemPost> , val itemEvents: ItemEvents) :
	 RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
	 lateinit var binding: ItemExploreBinding
	 
	  inner class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
			
	  fun bindViews(itemPost: ItemPost) {
	  	Glide.with(itemView.context).load(itemPost.imgUrl).into(binding.imgExploreMain)
	  	 binding.txtExploreDetail.text =itemPost.txtDetail
	  	 binding.txtExploreSubtitle.text =itemPost.txtSubtitle
	  	 binding.txtExploreTitle.text =itemPost.txtTitle
			 // send data by interface =========
	  	 itemView.setOnClickListener {
					itemEvents.onItemClicked(itemPost)
			 }
	  }
	  }
	 
	 override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ExploreViewHolder {
			binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
			return ExploreViewHolder(binding.root)
	 }
	 
	 override fun onBindViewHolder(holder: ExploreViewHolder , position: Int) {
		holder.bindViews(data[position])
		
	 }
	 
	 override fun getItemCount(): Int {
			return data.size
	 }
	 
	 
	 
	 
	 // (for searching part ) ->
	 @SuppressLint("NotifyDataSetChanged")
	 fun setData(newList: ArrayList<ItemPost>) {
			data.clear()
			data.addAll(newList)
			notifyDataSetChanged()
	 }
	 
	 
}