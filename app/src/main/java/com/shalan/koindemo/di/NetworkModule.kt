package com.shalan.koindemo.di

import com.shalan.koindemo.APIServices
import com.shalan.koindemo.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Mohamed Shalan on 4/17/20.
 */


val networkModule = module {

	single {
		HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
	}

	single {
		OkHttpClient.Builder()
			.addInterceptor(get<HttpLoggingInterceptor>())
			.build()
	}

	single {
		MoshiConverterFactory.create(Moshi.Builder().build())
	}

	single {
		RxJava2CallAdapterFactory.create()
	}

	single {
		Retrofit.Builder()
			.baseUrl(BuildConfig.BASE_URL)
			.addConverterFactory(get<MoshiConverterFactory>())
			.addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
			.client(get<OkHttpClient>())
			.build()
	}
}

val serviceModule = module {
	factory {
		get<Retrofit>().create(APIServices::class.java)
	}
}
