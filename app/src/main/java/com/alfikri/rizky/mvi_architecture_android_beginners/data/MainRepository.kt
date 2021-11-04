package com.alfikri.rizky.mvi_architecture_android_beginners.data

import com.alfikri.rizky.mvi_architecture_android_beginners.data.network.ApiHelper

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version MainRepository, v 0.1 11/3/2021 10:40 PM by Rizky Alfikri Rachmat
 */
class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUser()
}