package com.shalan.koindemo

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Mohamed Shalan on 4/17/20.
 */
class MainViewModel(private val repo: MainRepo): ViewModel(), KoinComponent {

	private val compositeDisposable: CompositeDisposable by inject()

	fun getUser() = repo.makeNetworkRequest().subscribe({

	}, {

	}).addTo(compositeDisposable)

	override fun onCleared() {
		super.onCleared()
		compositeDisposable.dispose()
	}
}
