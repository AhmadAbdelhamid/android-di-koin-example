package com.shalan.koindemo

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

/**
 * Created by Mohamed Shalan on 4/17/20.
 */
class MainViewModel(private val repo: MainRepo): ViewModel() {

	private val compositeDisposable: CompositeDisposable = CompositeDisposable()

	fun getUser() = repo.makeNetworkRequest().subscribe({

	}, {

	}).addTo(compositeDisposable)

	override fun onCleared() {
		super.onCleared()
		compositeDisposable.dispose()
	}
}
