package com.shalan.koindemo.di

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

/**
 * Created by Mohamed Shalan on 4/17/20.
 */


val otherModule = module {
	single {
		CompositeDisposable()
	}
}
