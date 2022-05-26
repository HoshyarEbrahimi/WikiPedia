package com.hoshyar.ebrahimi.wikipedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoshyar.ebrahimi.wikipedia.R
import com.hoshyar.ebrahimi.wikipedia.databinding.ActivityTranslateBinding

class TranslateActivity : AppCompatActivity() {
	  lateinit var binding : ActivityTranslateBinding
	 override fun onCreate(savedInstanceState: Bundle?) {
			super.onCreate(savedInstanceState)
			binding=ActivityTranslateBinding.inflate(layoutInflater)
			setContentView(binding.root)
	 }
}