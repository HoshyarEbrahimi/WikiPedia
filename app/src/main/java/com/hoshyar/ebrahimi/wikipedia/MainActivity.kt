package com.hoshyar.ebrahimi.wikipedia


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.snackbar.Snackbar
import com.hoshyar.ebrahimi.wikipedia.activity.TranslateActivity
import com.hoshyar.ebrahimi.wikipedia.databinding.ActivityMainBinding
import com.hoshyar.ebrahimi.wikipedia.fragments.FragmentExplore
import com.hoshyar.ebrahimi.wikipedia.fragments.FragmentPhotographer
import com.hoshyar.ebrahimi.wikipedia.fragments.FragmentProfile
import com.hoshyar.ebrahimi.wikipedia.fragments.FragmentTrend
import kotlin.system.exitProcess

const val SEND_ETSEARCHTEXT="SendEtsearchText"
class MainActivity : AppCompatActivity() {
	 private lateinit var binding: ActivityMainBinding
	 @SuppressLint("ResourceAsColor")
	 override fun onCreate(savedInstanceState: Bundle?) {
			super.onCreate(savedInstanceState)
			binding = ActivityMainBinding.inflate(layoutInflater)
			setContentView(binding.root)
			// first run fun :::
			firstRun()
			
			
			// set Navigation Drawer
			setSupportActionBar(binding.toolBarMain)
			val actionBarDrawerToggle = ActionBarDrawerToggle(
				 this ,
				 binding.drawerLayoutMain ,
				 binding.toolBarMain ,
				 R.string.openDrawer ,
				 R.string.closeDrawer
			)
			binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
			actionBarDrawerToggle.syncState()
			
			
			// handle click on navigating items :::
			binding.navigationViewMain.setNavigationItemSelectedListener {
				 when (it.itemId) {
						
						R.id.menu_photograph -> {
							 binding.navigationViewMain.menu.getItem(1).isChecked = true
							 binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
							 val transaction = supportFragmentManager.beginTransaction()
							 transaction.replace(R.id.fragment_container , FragmentPhotographer())
							 transaction.addToBackStack(null)
							 transaction.commit()
							 
							 
						}
						
						R.id.menu_translator -> {
							 binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
							 
							 val intent = Intent(this , TranslateActivity::class.java)
							 startActivity(intent)
							 
						}
						
						
						R.id.menu_writer -> {
							 binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
							 val dialog = SweetAlertDialog(this , SweetAlertDialog.SUCCESS_TYPE)
							 dialog.contentText = "Wanna be a writer ?"
							 dialog.titleText = "Alert"
							 dialog.confirmText = "Confirm"
							 dialog.cancelText = "Cancle"
							 dialog.show()
							 dialog.setConfirmClickListener {
									dialog.dismiss()
									val intent = Intent(
										 Intent.ACTION_VIEW ,
										 Uri.parse("https://en.wikipedia.org/wiki/Help:Your_first_article")
									)
									startActivity(intent)
							 }
							 dialog.setCancelClickListener {
									dialog.dismiss()
							 }
						}
						R.id.menu_videoMaker -> {
							 binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
							 
							 Snackbar.make(binding.root , "you don't have internet" , Snackbar.LENGTH_LONG)
									.setAction("Retry") {
										 Toast.makeText(this , " internet connected" , Toast.LENGTH_SHORT).show()
									}.setBackgroundTint(ContextCompat.getColor(this , R.color.blue))
									.setActionTextColor(ContextCompat.getColor(this , R.color.white))
									.show()
							 
						}
						
						
						R.id.menu_visit_wikimedia -> {
							 binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
							 val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://wikimedia.org"))
							 startActivity(intent)
						}
						
						
						R.id.menu_visit_wikipedia -> {
							 binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
							 val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://wikipedia.org"))
							 startActivity(intent)
						}
				 }
				 true
			}
			// handle click on bottom navigating items :::
			binding.bottomNavigationViewMain.setOnItemSelectedListener {
				 when (it.itemId) {
						R.id.menu_explore -> {
							 setFragment(FragmentExplore())
						}
						R.id.menu_profile -> {
							 setFragment(FragmentProfile())
						}
						R.id.menu_trend -> {
							 setFragment(FragmentTrend())
						}
				 }
				 
				 binding.navigationViewMain.menu.getItem(1).isChecked = false
				 
				 true
			}
			binding.bottomNavigationViewMain.setOnItemReselectedListener {}
			
			
//			// -------------------------------------- search
//			Log.v("work" , "now working")
//			if(binding.etMainSearch.text != null) {
//				 binding.etMainSearch.addTextChangedListener { _ ->
//						val etSerchText = binding.etMainSearch.text.toString()
//						val bundle = Bundle()
//						bundle.putString(SEND_ETSEARCHTEXT , etSerchText)
//						val fragmentExplore = FragmentExplore()
//						fragmentExplore.arguments = bundle
//				 }
//			}
	 }
	 
	 override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		 menuInflater.inflate(R.menu.menu_main  , menu)
			return true
	 }
	 
	 override fun onOptionsItemSelected(item: MenuItem): Boolean {
			when(item.itemId){
				 R.id.menuMain_exit ->{
				 	 finish()
				 }
			}
			return true
	 }
	 private fun setFragment(fragment: Fragment) {
			val transaction = supportFragmentManager.beginTransaction()
			transaction.replace(R.id.fragment_container , fragment)
			transaction.commit()
	 }
	 private fun firstRun() {
			setFragment(FragmentExplore())
	 }
	 override fun onBackPressed() {
			super.onBackPressed()
			binding.navigationViewMain.menu.getItem(1).isChecked = false
	 }
	 
	 
}