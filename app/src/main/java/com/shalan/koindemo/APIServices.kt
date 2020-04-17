package com.shalan.koindemo

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Mohamed Shalan on 4/17/20.
 */


interface APIServices {

	@GET("users")
	fun getUsers(): Single<List<User>>
}
