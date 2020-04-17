package com.shalan.koindemo.di

import com.shalan.koindemo.MainRepo
import org.koin.dsl.module

/**
 * Created by Mohamed Shalan on 4/17/20.
 */


val repoModule = module {
	factory {
		MainRepo(service = get())
	}
}
