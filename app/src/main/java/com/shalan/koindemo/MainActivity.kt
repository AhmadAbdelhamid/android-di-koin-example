package com.shalan.koindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

	lateinit var viewModel: MainViewModel


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val service = NetworkProvider.getService(APIServices::class.java)
		val repo = MainRepo(service)
		viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(MainViewModel::class.java)
		viewModel.getUser()
	}
}
