package com.hoshyar.ebrahimi.wikipedia

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.hoshyar.ebrahimi.wikipedia.data.ItemPost
import com.hoshyar.ebrahimi.wikipedia.databinding.ActivityMain2Binding
import com.hoshyar.ebrahimi.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY


class MainActivity2 : AppCompatActivity() {
	 lateinit var binding: ActivityMain2Binding
	 
	 @SuppressLint("ResourceAsColor")
	 override fun onCreate(savedInstanceState: Bundle?) {
			super.onCreate(savedInstanceState)
			binding = ActivityMain2Binding.inflate(layoutInflater)
			setContentView(binding.root)
			
			
			setSupportActionBar(binding.toolBarMain2)
			binding.collapsingMain.setExpandedTitleColor(
				 ContextCompat.getColor(this , android.R.color.transparent)
			)
			
			supportActionBar!!.setHomeButtonEnabled(true)
			supportActionBar!!.setDisplayHomeAsUpEnabled(true)
			val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
			if (dataPost != null) {
				 showData(dataPost)
			}
			
			
			// fab main 2
			binding.fabMain2.setOnClickListener {
				 val intent = Intent(Intent.ACTION_VIEW , Uri.parse("wikipedia.com"))
				 startActivity(intent)
			}
			
			
	 }
	 
	 private fun showData(itemPost: ItemPost) {
			binding.txtTitleMain2.text = itemPost.txtTitle
			Glide.with(this).load(itemPost.imgUrl).into(binding.imgDetail)
			binding.txtDetailMain2.text = itemPost.txtDetail
			binding.txtDetailSubTitle.text= itemPost.txtSubtitle
			binding.collapsingMain.title = itemPost.txtTitle
	 }
	 
	 override fun onOptionsItemSelected(item: MenuItem): Boolean {
			if (item.itemId == android.R.id.home) {
				 onBackPressed()
			}
			return true
	 }
}


