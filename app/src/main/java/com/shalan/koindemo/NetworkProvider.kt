package com.shalan.koindemo

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Mohamed Shalan on 4/17/20.
 */
object NetworkProvider {

	val client: Retrofit

	init {
		val okClient = OkHttpClient.Builder()
			.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
			.build()
		client = Retrofit.Builder()
			.baseUrl(BuildConfig.BASE_URL)
			.addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.client(okClient)
			.build()
	}
	fun <T> getService(service: Class<T>) = client.create(service)
}
