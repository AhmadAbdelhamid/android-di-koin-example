package com.shalan.koindemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Mohamed Shalan on 4/17/20.
 */
class ViewModelFactory(private val repo: MainRepo): ViewModelProvider.Factory {


	override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(repo) as T
}
