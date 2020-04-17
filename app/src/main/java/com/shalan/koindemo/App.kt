package com.shalan.koindemo

import android.app.Application
import com.shalan.koindemo.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Mohamed Shalan on 4/17/20.
 */
class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidLogger()
			androidContext(this@App)
			modules(listOf(networkModule, serviceModule, repoModule, viewModelModule, otherModule))
		}
	}
}
