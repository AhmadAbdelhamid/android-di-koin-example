package com.shalan.koindemo

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler

/**
 * Created by Mohamed Shalan on 4/17/20.
 */
class MainRepo(private val service: APIServices) {


	fun makeNetworkRequest() = service.getUsers().subscribeOn(IoScheduler())
		.observeOn(AndroidSchedulers.mainThread())
}
