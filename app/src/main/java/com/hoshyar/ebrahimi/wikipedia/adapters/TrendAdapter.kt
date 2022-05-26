package com.hoshyar.ebrahimi.wikipedia.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.TransformationUtils
import com.hoshyar.ebrahimi.wikipedia.data.ItemPost
import com.hoshyar.ebrahimi.wikipedia.databinding.ItemTrendBinding
import kotlin.math.round

class TrendAdapter(private val data: ArrayList<ItemPost> ,val itemEvents: ItemEvents) :
	 RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
	 lateinit var binding: ItemTrendBinding
	 
	 inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
			@SuppressLint("SetTextI18n")
			fun bindViews(itemPost: ItemPost) {
				 Glide.with(itemView.context).load(itemPost.imgUrl).into(binding.imgTrendMain)
				 binding.txtTrendTitle.text = itemPost.txtTitle
				 binding.txtTrendSubTitle.text = itemPost.txtSubtitle
				 binding.txtTrendInsight.text = itemPost.insight
				 binding.txtTrendNumber.text = (adapterPosition+1).toString()
				 
				 // send data by interface =====
				 itemView.setOnClickListener {
				 	 itemEvents.onItemClicked(itemPost)
				 }
				 
			}
			
	 }
	 
	 override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): TrendViewHolder {
			binding = ItemTrendBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
			return TrendViewHolder(binding.root)
	 }
	 
	 override fun onBindViewHolder(holder: TrendViewHolder , position: Int) {
			holder.bindViews(data[position])
			
			
	 }
	 
	 override fun getItemCount(): Int {
			return data.size
	 }
	 
	 
	 // add new List ( for searching part ) ->
	 @SuppressLint("NotifyDataSetChanged")
	 fun setData(newList: ArrayList<ItemPost>) {
			data.clear()
			data.addAll(newList)
			notifyDataSetChanged()
	 }
	 
}