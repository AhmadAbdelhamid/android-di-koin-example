package com.shalan.koindemo.di

import com.shalan.koindemo.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mohamed Shalan on 4/17/20.
 */


val viewModelModule = module {
	viewModel {
		MainViewModel(repo = get())
	}
}
